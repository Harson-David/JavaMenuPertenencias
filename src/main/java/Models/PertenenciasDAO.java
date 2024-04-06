package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
            = "SELECT pertenencia_id, pertenencia_tipo, pertenencia_descripcion, idUsuario "
            + "FROM pertenencias "
            + "JOIN users ON pertenencias.idUsuario = users.user_id "
            + "WHERE users.user_rol = ? AND users.user_id = ?";

    public static Pertenencias mapResultSetToPertenencia(ResultSet resultSet) throws SQLException {
        String pertenenciaId = resultSet.getString("pertenencia_id");
        String tipo = resultSet.getString("pertenencia_tipo");
        String descripcion = resultSet.getString("pertenencia_descripcion");
        int userId = resultSet.getInt("idUsuario");
        return new Pertenencias(pertenenciaId, tipo, descripcion, userId);
    }

    public static void create(Pertenencias pertenencia) {
        if (pertenencia == null) {
            System.out.println("El objeto pertenencia es nulo.");
            return;
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
            System.out.println("Pertenencia creada: \n" + pertenencia.toString());
        } catch (SQLException e) {
            e.printStackTrace();
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
