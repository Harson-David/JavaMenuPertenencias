package Models;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PertenenciasDAO {

    private static final String INSERT_QUERY = "INSERT INTO pertenencias (pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario FROM pertenencias";
    private static final String SELECT_ONE_QUERY = "SELECT pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario FROM pertenencias WHERE pertenencia_id=?";
    private static final String UPDATE_QUERY = "UPDATE pertenencias SET pertenencia_tipo=?, pertenencia_descripcion=?, idUsuario=? WHERE pertenencia_id=?";
    private static final String DELETE_QUERY = "DELETE FROM pertenencias WHERE pertenencia_id=?";
    private static final String SELECT_BY_USER_AND_TYPE_QUERY = "SELECT pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario " + "FROM pertenencias " + "JOIN users ON pertenencias.idUsuario = users.user_id " + "WHERE users.user_rol = ? AND users.user_id = ?";

    private static final String INSERT_BITACORA_QUERY = "INSERT INTO pertenencias_bitacora (pertenencia_id, bitacora_id) VALUES (?, ?)";

    public static Pertenencias mapResultSetToPertenencia(ResultSet resultSet) throws SQLException {
        String pertenenciaId = resultSet.getString("pertenencia_id");
        String tipo = resultSet.getString("pertenencia_tipo");
        String descripcion = resultSet.getString("pertenencia_descripcion");
        int userId = resultSet.getInt("idUsuario");
        return new Pertenencias(pertenenciaId, tipo, descripcion, userId);
    }

    public static Pertenencias create(Pertenencias pertenencia) {
        if (pertenencia == null) {
            throw new IllegalArgumentException("El objeto pertenencia es nulo.");
        }

        UUID uuid = UUID.randomUUID();
        String pertenencia_id = uuid.toString();

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, pertenencia_id);
            statement.setString(2, pertenencia.getTipo());
            statement.setString(3, pertenencia.getDescripcion());
            statement.setInt(4, pertenencia.getUserId());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        String id = generatedKeys.getString(1);
                        pertenencia.setPertenencia_id(id); // Asignar el ID generado a la instancia de Pertenencias
                    }
                }
            }

            return pertenencia;

        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la pertenencia.", e);
        }
    }


    public static void create_bitacora_pertenencia(List<String> pertenencia_ids, int bitacora_id) {
        if (pertenencia_ids == null || pertenencia_ids.isEmpty()) {
            throw new IllegalArgumentException("La lista de IDs de pertenencia no puede ser nula o vacía.");
        }

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_BITACORA_QUERY)) {
            for (String pertenencia_id : pertenencia_ids) {
                statement.setString(1, pertenencia_id);
                statement.setInt(2, bitacora_id);

                statement.addBatch(); // Agregar la operación a un lote para ejecutarla después
            }

            // Ejecutar todas las operaciones de inserción en un solo lote
            int[] rowsAffected = statement.executeBatch();

            // Verificar si todas las operaciones de inserción se realizaron correctamente
            for (int affected : rowsAffected) {
                if (affected == 0) {
                    throw new SQLException("No se pudo crear la entrada en la bitácora de pertenencia.");
                }
            }

            System.out.println("Inserción en la bitácora de pertenencia exitosa.");
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la entrada en la bitácora de pertenencia.", e);
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
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_USER_AND_TYPE_QUERY);
            statement.setInt(1, userId);
            statement.setString(2, userType);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Pertenencias pertenencia = mapResultSetToPertenencia(resultSet);
                pertenencias.add(pertenencia);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pertenencias;
    }
}
