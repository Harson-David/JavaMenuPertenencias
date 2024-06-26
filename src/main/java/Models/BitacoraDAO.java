package Models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class BitacoraDAO {

    private static final String INSERT_QUERY = "INSERT INTO bitacora (bitacora_fecha_ingreso, bitacora_hora_entrada, bitacora_hora_salida, bitacora_tipo, bitacora_descripcion, bitacora_fecha_salida, bitacora_hora_salida_equipo_sena, bitacora_motivo_salida, bitacora_motivo_ingreso) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT bitacora_id, bitacora_fecha_ingreso, bitacora_hora_entrada, bitacora_hora_salida, bitacora_tipo, bitacora_descripcion, bitacora_fecha_salida, bitacora_hora_salida_equipo_sena, bitacora_motivo_salida, bitacora_motivo_ingreso FROM bitacora";
    private static final String SELECT_ONE_QUERY = "SELECT bitacora_id, bitacora_fecha_ingreso, bitacora_hora_entrada, bitacora_hora_salida, bitacora_tipo, bitacora_descripcion, bitacora_fecha_salida, bitacora_hora_salida_equipo_sena, bitacora_motivo_salida, bitacora_motivo_ingreso FROM bitacora WHERE bitacora_id=?";
    private static final String UPDATE_QUERY = "UPDATE bitacora SET bitacora_fecha_ingreso=?, bitacora_hora_entrada=?, bitacora_hora_salida=?, bitacora_tipo=?, bitacora_descripcion=?, bitacora_fecha_salida=?, bitacora_hora_salida_equipo_sena=?, bitacora_motivo_salida=?, bitacora_motivo_ingreso=? WHERE bitacora_id=?";
    private static final String DELETE_QUERY = "DELETE FROM bitacora WHERE bitacora_id=?";

    private static Bitacora mapResultSetToBitacora(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("bitacora_id");
        Date fechaIngreso = resultSet.getDate("bitacora_fecha_ingreso");
        Time horaEntrada = resultSet.getTime("bitacora_hora_entrada");
        Time horaSalida = resultSet.getTime("bitacora_hora_salida");
        String tipo = resultSet.getString("bitacora_tipo");
        String descripcion = resultSet.getString("bitacora_descripcion");
        Date fechaSalida = resultSet.getDate("bitacora_fecha_salida");
        Time horaSalidaEquipoSena = resultSet.getTime("bitacora_hora_salida_equipo_sena");
        String motivoSalida = resultSet.getString("bitacora_motivo_salida");
        String motivoIngreso = resultSet.getString("bitacora_motivo_ingreso");

        return new Bitacora(id, fechaIngreso, horaEntrada, horaSalida, tipo, descripcion, fechaSalida, horaSalidaEquipoSena, motivoSalida, motivoIngreso);
    }

    public static void create(Bitacora bitacora) {
        if (bitacora == null) {
            throw new IllegalArgumentException("El objeto bitacora es nulo.");
        }

        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DataBase.getConnection();
            statement = connection.prepareStatement(INSERT_QUERY);
            statement.setDate(1, bitacora.getFechaIngreso());
            statement.setTime(2, bitacora.getHoraEntrada());
            statement.setTime(3, bitacora.getHoraSalida());
            statement.setString(4, bitacora.getTipo());
            statement.setString(5, bitacora.getDescripcion());
            statement.setDate(6, bitacora.getFechaSalida());
            statement.setTime(7, bitacora.getHoraSalidaEquipoSENA());
            statement.setString(8, bitacora.getMotivo_salida());
            statement.setString(9, bitacora.getMotivoIngreso());
            statement.executeUpdate();
            System.out.println("Bitácora creada: \n" + bitacora.toString());
        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la bitácora.", e);
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Bitacora createBit(Bitacora bitacora) {
        String query = "INSERT INTO bitacora (bitacora_fecha_ingreso, bitacora_hora_entrada, bitacora_hora_salida, bitacora_tipo) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS)) {
            statement.setDate(1, bitacora.getDateIngreso());
            statement.setTime(2, bitacora.getHourEntrada());

            if (bitacora.getHoraSalida() == null) {
                statement.setNull(3, Types.TIME);
            } else {
                statement.setTime(3, bitacora.getHoraSalida());
            }

            statement.setString(4, "ENTRADA");

            statement.executeUpdate();

            // Obtener el ID de la bitácora creada
            ResultSet generatedKeys = statement.getGeneratedKeys();
            int idBitacora = -1;
            if (generatedKeys.next()) {
                idBitacora = generatedKeys.getInt(1);
            }

            System.out.println("Bitácora creada exitosamente con ID: " + idBitacora);

            // Asignar el ID generado al objeto Bitacora y devolverlo
            bitacora.setBitacoraId(idBitacora);
            return bitacora;
        } catch (SQLException e) {
            System.out.println("Error al crear la bitácora: " + e.getMessage());
            return null;
        }
    }

    public static void updateBit(Bitacora bitacora) {
        String query = "UPDATE bitacora SET bitacora_fecha_ingreso=?, bitacora_hora_entrada=?, bitacora_hora_salida=?, bitacora_tipo=? WHERE bitacora_id=?";

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, bitacora.getFechaIngreso());
            statement.setTime(2, bitacora.getHoraEntrada());
            statement.setTime(3, bitacora.getHourSalida());
            statement.setString(4, "SALIDA");
            statement.setInt(5, bitacora.getBitacoraId());

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Bitácora Actualizada exitosamente.");
                System.out.println("Campos actualizados: fecha_ingreso, hora_entrada, hora_salida, tipo");
            } else {
                System.out.println("No se encontró ninguna fila para actualizar.");
            }
        } catch (SQLException e) {
            System.out.println("Error al Actualizar la bitácora: " + e.getMessage());
        }
    }

    public static void reUpdateBit(Bitacora bitacora) {
        String query = "UPDATE bitacora SET bitacora_fecha_ingreso=?, bitacora_hora_entrada=?, bitacora_hora_salida=?, bitacora_tipo=? WHERE bitacora_id=?";

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, bitacora.getDateIngreso());
            statement.setTime(2, bitacora.getHourEntrada());

            // Verificar si la hora de salida no está vacía, si no esta se convierte a NULL
            if (bitacora.getHourSalida() == null) {
                statement.setNull(3, Types.TIME);
            } else {
                statement.setTime(3, null);
            }

            statement.setString(4, "ENTRADA");
            statement.setInt(5, bitacora.getBitacoraId());

            statement.executeUpdate();
            System.out.println("Bitácora Actualizada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al Actualizar la bitácora: " + e.getMessage());
        }
    }

    public static List<Bitacora> findAll() {
        List<Bitacora> bitacoras = new ArrayList<>();

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Bitacora bitacora = mapResultSetToBitacora(resultSet);
                bitacoras.add(bitacora);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bitacoras;
    }

    public static Bitacora findOne(int idBitacora) {
        Bitacora bitacora = null;
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ONE_QUERY);
            statement.setInt(1, idBitacora);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                bitacora = mapResultSetToBitacora(resultSet);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bitacora;
    }

    public static void update(Bitacora bitacora) {
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setDate(1, bitacora.getFechaIngreso());
            statement.setTime(2, bitacora.getHoraEntrada());
            statement.setTime(3, bitacora.getHoraSalida());
//            statement.setString(4, bitacora.getTipo());
//            statement.setString(5, bitacora.getDescripcion());
//            statement.setDate(6, bitacora.getFechaSalida());
//            statement.setTime(7, bitacora.getHoraSalidaEquipoSENA());
//            statement.setString(8, bitacora.getMotivo_salida());
//            statement.setString(9, bitacora.getMotivoIngreso());
//            statement.setInt(10, bitacora.getBitacoraId());
            statement.executeUpdate();
            System.out.println("Bitácora actualizada: " + bitacora.toString());
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void disableForeignKeyChecks() throws SQLException {
        Connection connection = DataBase.getConnection();
        PreparedStatement statement = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=0");
        statement.execute();
        statement.close();
        connection.close();
    }

    public static void enableForeignKeyChecks() throws SQLException {
        Connection connection = DataBase.getConnection();
        PreparedStatement statement = connection.prepareStatement("SET FOREIGN_KEY_CHECKS=1");
        statement.execute();
        statement.close();
        connection.close();
    }

    public static void delete(int id) {
        Bitacora deletedBitacora = findOne(id);
        try {
            disableForeignKeyChecks();
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Bitácora eliminada: " + deletedBitacora.toString());
            statement.close();
            connection.close();
            enableForeignKeyChecks();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//    public static List<Bitacora> findByPertenenciaId(String pertenencia_id) {
//        List<Bitacora> bitacoras = new ArrayList<>();
//
//        // Consulta SQL mejorada utilizando las tablas de pertenencias y bitácora
//        String query = "SELECT b.* FROM bitacora b "
//                + "JOIN pertenencias_bitacora pb ON b.bitacora_id = pb.bitacora_id "
//                + "JOIN pertenencias p ON pb.pertenencia_id = p.pertenencia_id "
//                + "WHERE p.pertenencia_id = ?";
//
//        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {
//            // Establecer el parámetro de la consulta de manera segura
//            statement.setString(1, pertenencia_id);
//
//            // Ejecutar la consulta
//            try (ResultSet resultSet = statement.executeQuery()) {
//                // Mapear los resultados a objetos Bitacora y agregarlos a la lista
//                while (resultSet.next()) {
//                    Bitacora bitacora = mapResultSetToBitacora(resultSet);
//                    bitacoras.add(bitacora);
//                }
//            }
//        } catch (SQLException e) {
//            // Manejar cualquier excepción de SQL
//            e.printStackTrace();
//        }
//
//        return bitacoras;
//    }
//
//    private int generateRandomId() {
//        int min = 100000;
//        int max = 999999;
//        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
//        return randomNum;
//    }
}
