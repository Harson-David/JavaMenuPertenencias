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
    private static final String UPDATE_APRENDIZ_QUERY = "UPDATE users SET user_type_document=?, user_password=?, user_name=?, user_last_name=?, user_num_contact=?, user_address=?, user_email=?, user_jornada=?, user_tipo_formacion=?, user_centro_formacion=?, user_coordinacion=?, user_num_ficha=? WHERE user_id=?";

    private static final String UPDATE_INSTRUCTOR_QUERY = "UPDATE users SET user_type_document=?, user_password=?, user_name=?, user_last_name=?, user_num_contact=?, user_address=?, user_email=?, user_jornada=?, user_tipo_formacion=?, user_centro_formacion=?, user_coordinacion=?, user_formacion=? WHERE user_id=?";

    private static final String UPDATE_FUNCIONARIO_QUERY = "UPDATE users SET user_type_document=?, user_password=?, user_name=?, user_last_name=?, user_num_contact=?, user_address=?, user_email=?, user_jornada=?, user_centro_formacion=?, user_coordinacion=?, user_cargo_actual=? WHERE user_id=?";

    private static final String UPDATE_EXTERNO_QUERY = "UPDATE users SET user_type_document=?, user_password=?, user_name=?, user_last_name=?, user_num_contact=?, user_address=?, user_email=?, user_lugar_procedencia=? WHERE user_id=?";

    private static final String UPDATE_ADMINISTRADOR_QUERY = "UPDATE users SET user_type_document=?, user_password=?, user_name=?, user_last_name=?, user_num_contact=?, user_address=?, user_email=?, user_jornada=?, user_tipo_formacion=?, user_centro_formacion=?, user_coordinacion=?, user_num_ficha=?, user_formacion=?, user_cargo_actual=?, user_lugar_procedencia=? WHERE user_id=?";

    public static Users.UserRole mapToUserRole(String value) {
        switch (value) {
            case "APRENDIZ":
                return Users.UserRole.APRENDIZ;
            case "INSTRUCTOR":
                return Users.UserRole.INSTRUCTOR;
            case "FUNCIONARIO":
                return Users.UserRole.FUNCIONARIO;
            case "EXTERNO":
                return Users.UserRole.EXTERNO;
            case "ADMINISTRADOR":
                return Users.UserRole.ADMINISTRADOR;
            default:
                return null;
        }
    }

    public static Users.UserTypeDocument mapToUserTypeDocument(String value) {
        switch (value) {
            case "CC":
                return Users.UserTypeDocument.CC;
            case "TI":
                return Users.UserTypeDocument.TI;
            case "CE":
                return Users.UserTypeDocument.CE;
            case "PASAPORTE":
                return Users.UserTypeDocument.PASAPORTE;
            default:
                return null;
        }
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
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
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
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_APRENDIZ_QUERY);

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

            statement.executeUpdate();
            System.out.println("Usuario actualizado: " + user.toString());

            statement.close();
            connection.close();
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
            PreparedStatement statement = connection.prepareStatement(UPDATE_INSTRUCTOR_QUERY);

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

            statement.executeUpdate();
            System.out.println("Usuario actualizado: " + user.toString());

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
            PreparedStatement statement = connection.prepareStatement(UPDATE_FUNCIONARIO_QUERY);

            statement.setString(1, user.getTypeDocument().name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getNumContact());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getEmail());
            statement.setString(8, user.getCentroFormacion());
            statement.setString(9, user.getCoordinacion());
            statement.setString(10, user.getCargoActual());

            statement.executeUpdate();
            System.out.println("Usuario actualizado: " + user.toString());

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
            PreparedStatement statement = connection.prepareStatement(UPDATE_EXTERNO_QUERY);

            statement.setString(1, user.getTypeDocument().name());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4, user.getLastName());
            statement.setInt(5, user.getNumContact());
            statement.setString(6, user.getAddress());
            statement.setString(7, user.getLugarProcedencia());

            statement.executeUpdate();
            System.out.println("Usuario actualizado: " + user.toString());

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
            PreparedStatement statement = connection.prepareStatement(UPDATE_ADMINISTRADOR_QUERY);

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
            statement.setInt(13, user.getFormacion());
            statement.setString(14, user.getCargoActual());
            statement.setString(15, user.getLugarProcedencia());
            statement.setInt(16, user.getUser_id());  // Aquí se establece el valor para el último parámetro

            statement.executeUpdate();
            System.out.println("Usuario actualizado: " + user.toString());

            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Users> findAll() {
        List<Users> usersList = new ArrayList<>();

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Users user = mapResultSetToUser(resultSet);
                usersList.add(user);
            }

            resultSet.close();
            statement.close();
            connection.close();
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
