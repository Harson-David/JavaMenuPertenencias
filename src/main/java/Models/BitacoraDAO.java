package Models;

import java.sql.*;
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

    public static Bitacora create(Bitacora bitacora) {
        if (bitacora == null) {
            throw new IllegalArgumentException("El objeto bitacora es nulo.");
        }

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            statement.setDate(1, bitacora.getFechaIngreso());
            statement.setTime(2, bitacora.getHoraEntrada());
            statement.setTime(3, bitacora.getHoraSalida());
            statement.setString(4, bitacora.getTipo());
            statement.setString(5, bitacora.getDescripcion());
            statement.setDate(6, bitacora.getFechaSalida());
            statement.setTime(7, bitacora.getHoraSalidaEquipoSENA());
            statement.setString(8, bitacora.getMotivo_salida());
            statement.setString(9, bitacora.getMotivoIngreso());

            int rowsAffected = statement.executeUpdate();

            if (rowsAffected > 0) {
                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        int id = generatedKeys.getInt(1);
                        bitacora.setBitacoraId(id); // Asignar el ID generado a la instancia de Bitacora
                    }
                }
            }

            // System.out.println("Bitácora creada: \n" + bitacora);
            return bitacora;

        } catch (SQLException e) {
            throw new RuntimeException("Error al crear la bitácora.", e);
        }
    }


// BitacoraDAO.java


    public static void createBit(Bitacora bitacora) {
        String query = "INSERT INTO bitacora (bitacora_id, bitacora_fecha_ingreso, bitacora_hora_entrada, bitacora_hora_salida) VALUES (?, ?, ?, ?)";

        try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, bitacora.getBitacoraId());
            statement.setDate(2, bitacora.getDateIngreso());
            statement.setTime(3, bitacora.getHourEntrada());

            if (bitacora.getHoraSalida() == null) {
                statement.setNull(4, Types.TIME);
            } else {
                statement.setTime(4, bitacora.getHoraSalida());
            }

            statement.executeUpdate();
            System.out.println("Bitácora creada exitosamente.");
        } catch (SQLException e) {
            System.out.println("Error al crear la bitácora: " + e.getMessage());
        }
    }

    //        private int generateRandomId() {
//        int min = 100000;
//        int max = 999999;
//        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
//        return randomNum;
//    }
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

    private int generateRandomId() {
        int min = 100000;
        int max = 999999;
        int randomNum = min + (int) (Math.random() * ((max - min) + 1));
        return randomNum;
    }
}
