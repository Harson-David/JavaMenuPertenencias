package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

public class UsersDAO {

    private static final String INSERT_QUERY = "INSERT INTO users (user_id, user_rol, user_type_document, user_password, user_name, user_last_name, user_num_contact, user_address, user_email, user_jornada, user_tipo_formacion, user_centro_formacion, user_coordinacion, user_num_ficha, user_formacion, user_cargo_actual, user_lugar_procedencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT user_id, user_rol, user_type_document, user_password, user_name, user_last_name, user_num_contact, user_address, user_email, user_jornada, user_tipo_formacion, user_centro_formacion, user_coordinacion, user_num_ficha, user_formacion, user_cargo_actual, user_lugar_procedencia FROM users";
    private static final String SELECT_ONE_QUERY = "SELECT user_id, user_rol, user_type_document, user_password, user_name, user_last_name, user_num_contact, user_address, user_email, user_jornada, user_tipo_formacion, user_centro_formacion, user_coordinacion, user_num_ficha, user_formacion, user_cargo_actual, user_lugar_procedencia FROM users WHERE user_id=?";
    private static final String UPDATE_QUERY = "UPDATE users SET user_rol=?, user_type_document=?, user_password=?, user_name=?, user_last_name=?, user_num_contact=?, user_address=?, user_email=?, user_jornada=?, user_tipo_formacion=?, user_centro_formacion=?, user_coordinacion=?, user_num_ficha=?, user_formacion=?, user_cargo_actual=?, user_lugar_procedencia=? WHERE user_id=?";
    private static final String DELETE_QUERY = "DELETE FROM users WHERE user_id=?";

    private static final String UPDATEADMIN_QUERY = "UPDATE users SET "
            + "user_type_document = ?, "
            + "user_password = ?, "
            + "user_name = ?, "
            + "user_last_name = ?, "
            + "user_num_contact = ?, "
            + "user_address = ?, "
            + "user_email = ?, "
            + "user_jornada = ?, "
            + "user_centro_formacion = ?, "
            + "user_coordinacion = ? "
            + "WHERE user_id = ? AND user_rol = 'ADMINISTRADOR'";

    private static final String UPDATEFUNCIONARIO_QUERY = "UPDATE users SET "
            + "user_type_document = ?, "
            + "user_password = ?, "
            + "user_name = ?, "
            + "user_last_name = ?, "
            + "user_num_contact = ?, "
            + "user_address = ?, "
            + "user_email = ?, "
            + "user_jornada = ?, "
            + "user_centro_formacion = ?, "
            + "user_coordinacion = ?, "
            + "user_cargo_actual = ? "
            + "WHERE user_id = ? AND user_rol = 'FUNCIONARIO'";

    private static final String UPDATEAPRENDIZ_QUERY = "UPDATE users SET "
            + "user_type_document = ?, "
            + "user_password = ?, "
            + "user_name = ?, "
            + "user_last_name = ?, "
            + "user_num_contact = ?, "
            + "user_address = ?, "
            + "user_email = ?, "
            + "user_jornada = ?, "
            + "user_tipo_formacion = ?, "
            + "user_centro_formacion = ?, "
            + "user_coordinacion = ?, "
            + "user_num_ficha = ? "
            + "WHERE user_id = ? AND user_rol = 'APRENDIZ'";

    private static final String UPDATEINSTRUCTOR_QUERY = "UPDATE users SET "
            + "user_type_document = ?, "
            + "user_password = ?, "
            + "user_name = ?, "
            + "user_last_name = ?, "
            + "user_num_contact = ?, "
            + "user_address = ?, "
            + "user_email = ?, "
            + "user_jornada = ?, "
            + "user_tipo_formacion = ?, "
            + "user_centro_formacion = ?, "
            + "user_coordinacion = ?, "
            + "user_formacion = ? "
            + "WHERE user_id = ? AND user_rol = 'INSTRUCTOR'";

    private static final String UPDATEEXTERNO_QUERY = "UPDATE users SET "
            + "user_type_document = ?, "
            + "user_password = ?, "
            + "user_name = ?, "
            + "user_last_name = ?, "
            + "user_num_contact = ?, "
            + "user_address = ?, "
            + "user_email = ?, "
            + "user_lugar_procedencia = ? "
            + "WHERE user_id = ? AND user_rol = 'EXTERNO'";

    public static Users.UserRole mapToUserRole(String value) {
        return switch (value) {
            case "APRENDIZ" ->
                Users.UserRole.APRENDIZ;
            case "INSTRUCTOR" ->
                Users.UserRole.INSTRUCTOR;
            case "FUNCIONARIO" ->
                Users.UserRole.FUNCIONARIO;
            case "EXTERNO" ->
                Users.UserRole.EXTERNO;
            case "ADMINISTRADOR" ->
                Users.UserRole.ADMINISTRADOR;
            default ->
                null;
        };
    }

    public static Users.UserTypeDocument mapToUserTypeDocument(String value) {
        return switch (value) {
            case "CC" ->
                Users.UserTypeDocument.CC;
            case "TI" ->
                Users.UserTypeDocument.TI;
            case "CE" ->
                Users.UserTypeDocument.CE;
            case "PASAPORTE" ->
                Users.UserTypeDocument.PASAPORTE;
            default ->
                null;
        };
    }

    public static Users mapResultSetToUser(ResultSet resultSet) throws SQLException {
        int userId = resultSet.getInt("user_id");
        Users.UserRole userRole = mapToUserRole(resultSet.getString("user_rol"));
        Users.UserTypeDocument userTypeDocument = mapToUserTypeDocument(resultSet.getString("user_type_document"));
        String password = resultSet.getString("user_password");
        String name = resultSet.getString("user_name");
        String lastName = resultSet.getString("user_last_name");
        int numContact = resultSet.getInt("user_num_contact");
        String address = resultSet.getString("user_address");
        String email = resultSet.getString("user_email");
        String jornada = resultSet.getString("user_jornada");
        String tipoFormacion = resultSet.getString("user_tipo_formacion");
        String centroFormacion = resultSet.getString("user_centro_formacion");
        String coordinacion = resultSet.getString("user_coordinacion");
        int numFicha = resultSet.getInt("user_num_ficha");
        int formacion = resultSet.getInt("user_formacion");
        String cargoActual = resultSet.getString("user_cargo_actual");
        String lugarProcedencia = resultSet.getString("user_lugar_procedencia");
        return new Users(userId, userRole, userTypeDocument, password, name, lastName, numContact, address, email, jornada, tipoFormacion, centroFormacion, coordinacion, numFicha, formacion, cargoActual, lugarProcedencia);
    }

    public static void create(Users user) {
        if (user == null) {
            System.out.println("El objeto usuario es nulo.");
            return;
        }

        try {
            try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(INSERT_QUERY)) {
                statement.setInt(1, user.getUser_id());
                statement.setString(2, user.getUserRol().name());
                statement.setString(3, user.getTypeDocument().name());
                statement.setString(4, user.getPassword());
                statement.setString(5, user.getName());
                statement.setString(6, user.getLastName());
                statement.setInt(7, user.getNumContact());
                statement.setString(8, user.getAddress());
                statement.setString(9, user.getEmail());
                statement.setString(10, user.getJornada());
                statement.setString(11, user.getTipoFormacion());
                statement.setString(12, user.getCentroFormacion());
                statement.setString(13, user.getCoordinacion());
                statement.setInt(14, user.getNumFicha());
                statement.setInt(15, user.getFormacion());
                statement.setString(16, user.getCargoActual());
                statement.setString(17, user.getLugarProcedencia());
                statement.executeUpdate();
                System.out.println("Usuario creado: \n" + user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Users> findAll() {
        List<Users> usersList = new ArrayList<>();

        try {
            try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY)) {
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    Users user = mapResultSetToUser(resultSet);
                    usersList.add(user);
                }
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usersList;
    }

    public static Users findOne(int userId) {
        Users user = null;
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ONE_QUERY);
            statement.setInt(1, userId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = mapResultSetToUser(resultSet);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    public static void update(Users user) {
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);

            statement.setString(1, user.getUserRol().name());
            statement.setString(2, user.getTypeDocument().name());
            statement.setString(3, user.getPassword());
            statement.setString(4, user.getName());
            statement.setString(5, user.getLastName());
            statement.setInt(6, user.getNumContact());
            statement.setString(7, user.getAddress());
            statement.setString(8, user.getEmail());
            statement.setString(9, user.getJornada());
            statement.setString(10, user.getTipoFormacion());
            statement.setString(11, user.getCentroFormacion());
            statement.setString(12, user.getCoordinacion());
            statement.setInt(13, user.getNumFicha());
            statement.setInt(14, user.getFormacion());
            statement.setString(15, user.getCargoActual());
            statement.setString(16, user.getLugarProcedencia());
            statement.setInt(17, user.getUser_id());

            statement.executeUpdate();
            System.out.println("Usuario actualizado: " + user.toString());

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAprendiz(Users user) {
        if (user == null) {
            System.out.println("El objeto usuario es nulo.");
            return;
        }

        try {
            try (Connection connection = DataBase.getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATEAPRENDIZ_QUERY)) {

                statement.setString(1, user.getTypeDocument().name());
                statement.setString(2, user.getPassword());
                statement.setString(3, user.getName());
                statement.setString(4, user.getLastName());
                statement.setInt(5, user.getNumContact());
                statement.setString(6, user.getAddress());
                statement.setString(7, user.getEmail());
                statement.setString(8, user.getJornada());
                statement.setString(9, user.getTipoFormacion());
                statement.setString(10, user.getCentroFormacion());
                statement.setString(11, user.getCoordinacion());
                statement.setInt(12, user.getNumFicha());
                statement.setInt(13, user.getUser_id());

                statement.executeUpdate();
                System.out.println("Usuario aprendiz actualizado: " + user.toString());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateInstructor(Users user) {
        if (user == null) {
            System.out.println("El objeto usuario es nulo.");
            return;
        }

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATEINSTRUCTOR_QUERY);

            statement.setString(1, user.getTypeDocument().name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getNumContact());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getJornada());
            statement.setString(9, user.getTipoFormacion());
            statement.setString(10, user.getCentroFormacion());
            statement.setString(11, user.getCoordinacion());
            statement.setInt(12, user.getFormacion());
            statement.setInt(13, user.getUser_id());

            statement.executeUpdate();
            System.out.println("Usuario instructor actualizado: " + user.toString());

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateFuncionario(Users user) {
        if (user == null) {
            System.out.println("El objeto usuario es nulo.");
            return;
        }

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATEFUNCIONARIO_QUERY);

            statement.setString(1, user.getTypeDocument().name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getNumContact());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getJornada());
            statement.setString(9, user.getCentroFormacion());
            statement.setString(10, user.getCoordinacion());
            statement.setString(11, user.getCargoActual());
            statement.setInt(12, user.getUser_id());

            statement.executeUpdate();
            System.out.println("Usuario funcionario actualizado: " + user.toString());

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateExterno(Users user) {
        if (user == null) {
            System.out.println("El objeto usuario es nulo.");
            return;
        }

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATEEXTERNO_QUERY);

            statement.setString(1, user.getTypeDocument().name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getNumContact());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getLugarProcedencia());
            statement.setInt(9, user.getUser_id());

            statement.executeUpdate();
            System.out.println("Usuario externo actualizado: " + user.toString());

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAdministrador(Users user) {
        if (user == null) {
            System.out.println("El objeto usuario es nulo.");
            return;
        }

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATEADMIN_QUERY);

            statement.setString(1, user.getTypeDocument().name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getNumContact());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getJornada());
            statement.setString(9, user.getCentroFormacion());
            statement.setString(10, user.getCoordinacion());
            statement.setInt(11, user.getUser_id());

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("Usuario administrador actualizado: " + user.toString());
            } else {
                System.out.println("No se encontró ningún usuario administrador para actualizar.");
            }

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

    public static void delete(int userId) {
        Users deletedUser = findOne(userId);

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, userId);
            statement.executeUpdate();

            System.out.println("Usuario eliminado: " + deletedUser.toString());

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
