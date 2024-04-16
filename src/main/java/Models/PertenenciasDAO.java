package Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PertenenciasDAO {

    private static final String INSERT_QUERY = "INSERT INTO pertenencias (pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario FROM pertenencias";
    private static final String SELECT_ONE_QUERY = "SELECT pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario FROM pertenencias WHERE pertenencia_id=?";
    private static final String UPDATE_QUERY = "UPDATE pertenencias SET pertenencia_tipo=?, pertenencia_descripcion=?, idUsuario=? WHERE pertenencia_id=?";
    private static final String DELETE_QUERY = "DELETE FROM pertenencias WHERE pertenencia_id=?";
    private static final String SELECT_BY_USER_AND_TYPE_QUERY
            = "SELECT p.pertenencia_id, p.pertenencia_tipo, p.pertenencia_descripcion, p.idUsuario, pb.bitacora_id, "
            + "b.bitacora_fecha_ingreso, b.bitacora_hora_entrada, b.bitacora_hora_salida, b.bitacora_tipo "
            + "FROM pertenencias p "
            + "JOIN pertenencias_bitacora pb ON p.pertenencia_id = pb.pertenencia_id "
            + "JOIN bitacora b ON pb.bitacora_id = b.bitacora_id "
            + "JOIN users u ON p.idUsuario = u.user_id "
            + "WHERE u.user_rol = ? AND u.user_id = ?";

    private static final String PERTENENCIAS_BITACORA_QUERY = "SELECT p.pertenencia_id, "
            + "p.pertenencia_tipo, "
            + "p.pertenencia_descripcion, "
            + "p.idUsuario, "
            + "b.bitacora_id, "
            + "b.bitacora_fecha_ingreso, "
            + "b.bitacora_hora_entrada, "
            + "b.bitacora_hora_salida, "
            + "b.bitacora_tipo "
            + "FROM pertenencias p "
            + "INNER JOIN pertenencias_bitacora pb ON p.pertenencia_id = pb.pertenencia_id "
            + "INNER JOIN bitacora b ON pb.bitacora_id = b.bitacora_id";

    public static Pertenencias mapResultSetToPertenencia(ResultSet resultSet) throws SQLException {

        System.out.println("pertenencia_id: " + resultSet.getString("pertenencia_id"));
        System.out.println("pertenencia_tipo: " + resultSet.getString("pertenencia_tipo"));
        System.out.println("pertenencia_descripcion: " + resultSet.getString("pertenencia_descripcion"));
        System.out.println("idUsuario: " + resultSet.getInt("idUsuario"));
        System.out.println("bitacora_id: " + resultSet.getInt("bitacora_id"));
        System.out.println("bitacora_fecha_ingreso: " + resultSet.getDate("bitacora_fecha_ingreso"));
        System.out.println("bitacora_hora_entrada: " + resultSet.getTime("bitacora_hora_entrada"));
        System.out.println("bitacora_hora_salida: " + resultSet.getTime("bitacora_hora_salida"));
        System.out.println("bitacora_tipo: " + resultSet.getString("bitacora_tipo"));

        // Obtener los valores del ResultSet 
        String pertenenciaId = resultSet.getString("pertenencia_id");
        String tipo = resultSet.getString("pertenencia_tipo");
        String descripcion = resultSet.getString("pertenencia_descripcion");
        int userId = resultSet.getInt("idUsuario");
        int bitacoraId = resultSet.getInt("bitacora_id");
        Date fechaIngreso = resultSet.getDate("bitacora_fecha_ingreso");
        Time horaEntrada = resultSet.getTime("bitacora_hora_entrada");
        Time horaSalida = resultSet.getTime("bitacora_hora_salida");
        String bitacoraTipo = resultSet.getString("bitacora_tipo");

        // Devolver los campos de ambas tablas
        return new Pertenencias(pertenenciaId, tipo, descripcion, userId, bitacoraId, fechaIngreso, horaEntrada, horaSalida, bitacoraTipo);
    }

    public static Pertenencias create(Pertenencias pertenencia) {
        if (pertenencia == null) {
            System.out.println("El objeto pertenencia es nulo.");
            return null;
        }

        UUID uuid = UUID.randomUUID();
        String pertenenciaId = uuid.toString();

        try (Connection connection = DataBase.getConnection()) {
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setString(1, pertenenciaId);
            statement.setString(2, pertenencia.getTipo());
            statement.setString(3, pertenencia.getDescripcion());
            statement.setInt(4, pertenencia.getUserId());
            statement.executeUpdate();

            System.out.println("Pertenencia creada exitosamente con ID: " + pertenenciaId);

            // Asignar el ID generado al objeto Pertenencias y devolverlo
            pertenencia.setPertenencia_id(pertenenciaId);
            return pertenencia;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static List<Pertenencias> findAll() {
        List<Pertenencias> pertenenciasList = new ArrayList<>();

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Pertenencias pertenencia = mapResultSetToPertenencia(resultSet);
                pertenenciasList.add(pertenencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pertenenciasList;
    }

    public static Pertenencias findOne(String pertenenciaId) {
        Pertenencias pertenencia = null;
        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ONE_QUERY)) {
            statement.setString(1, pertenenciaId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    pertenencia = mapResultSetToPertenencia(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pertenencia;
    }

    public static void update(Pertenencias pertenencia) {
        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, pertenencia.getTipo());
            statement.setString(2, pertenencia.getDescripcion());
            statement.setInt(3, pertenencia.getUserId());
            statement.setString(4, pertenencia.getPertenencia_id());
            statement.executeUpdate();
            System.out.println("Pertenencia actualizada: " + pertenencia.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updatePer(Pertenencias pertenencia) {
        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY)) {
            statement.setString(1, pertenencia.getTipo());
            statement.setString(2, pertenencia.getDescripcion());
            //statement.setInt(3, pertenencia.getUserId());
            //statement.setString(4, pertenencia.getPertenencia_id());
            statement.executeUpdate();
            System.out.println("Pertenencia actualizada: " + pertenencia.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disableForeignKeyChecks() throws SQLException {
        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0")) {
            statement.execute();
        }
    }

    public static void enableForeignKeyChecks() throws SQLException {
        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1")) {
            statement.execute();
        }
    }

    public static void delete(String pertenenciaId) {
        Pertenencias deletedPertenencia = findOne(pertenenciaId);
        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_QUERY)) {
            statement.setString(1, pertenenciaId);
            statement.executeUpdate();
            System.out.println("Pertenencia eliminada: " + deletedPertenencia.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Pertenencias> findByUserAndType(int userId, String userType) {
        List<Pertenencias> pertenencias = new ArrayList<>();
        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_BY_USER_AND_TYPE_QUERY)) {
            statement.setString(1, userType);
            statement.setInt(2, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Pertenencias pertenencia = mapResultSetToPertenencia(resultSet);
                    pertenencias.add(pertenencia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pertenencias;
    }

    public static List<Pertenencias> findAllPertenenciasBitacora() {
        List<Pertenencias> pertenenciasList = new ArrayList<>();

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement
                = connection.prepareStatement(PERTENENCIAS_BITACORA_QUERY); ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Pertenencias pertenencia = mapResultSetToPertenencia(resultSet);
                pertenenciasList.add(pertenencia);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pertenenciasList;
    }

//    public static List<Pertenencias> findByUserAndTypeBita(int userId, String userType, String bitacoraType) {
//        List<Pertenencias> pertenencias = new ArrayList<>();
//        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(PERTENENCIAS_BITACORA_QUERY)) {
//            statement.setInt(1, userId);
//            statement.setString(2, bitacoraType);
//            try (ResultSet resultSet = statement.executeQuery()) {
//                while (resultSet.next()) {
//                    Pertenencias pertenencia = mapResultSetToPertenencia(resultSet);
//                    pertenencias.add(pertenencia);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return pertenencias;
//    }
    public void crearRelacionPertenenciaBitacora(String pertenenciaId, int bitacoraId) {
        String query = "INSERT INTO pertenencias_bitacora (pertenencia_id, bitacora_id) VALUES (?, ?)";

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, pertenenciaId);
            statement.setInt(2, bitacoraId);

            statement.executeUpdate();

            System.out.println("Relación entre pertenencia y bitácora creada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la relación entre pertenencia y bitácora: " + e.getMessage());
        }
    }

}
