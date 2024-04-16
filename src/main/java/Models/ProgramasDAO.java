package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProgramasDAO {

    private static final String INSERT_QUERY = "INSERT INTO programas (programa_id, programa_nombre_del_programa, programa_centro_formacion, programa_coordinacion) VALUES (?, ?, ?, ?)";
    private static final String SELECT_ALL_QUERY = "SELECT programa_id, programa_nombre_del_programa, programa_centro_formacion, programa_coordinacion FROM programas";
    private static final String SELECT_ONE_QUERY = "SELECT programa_id, programa_nombre_del_programa, programa_centro_formacion, programa_coordinacion FROM programas WHERE programa_id=?";
    private static final String UPDATE_QUERY = "UPDATE programas SET programa_nombre_del_programa=?, programa_centro_formacion=?, programa_coordinacion=? WHERE programa_id=?";
    private static final String DELETE_QUERY = "DELETE FROM programas WHERE programa_id=?";

    private static Programas mapResultSetToPrograma(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("programa_id");
        String nombre = resultSet.getString("programa_nombre_del_programa");
        String centro = resultSet.getString("programa_centro_formacion");
        String coordinacion = resultSet.getString("programa_coordinacion");

        return new Programas(id, nombre, centro, coordinacion);
    }

    public static void create(Programas programa) {
        if (programa == null) {
            System.out.println("El objeto programa es nulo.");
            return;
        }

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(INSERT_QUERY);
            statement.setInt(1, programa.getid_Programa());
            statement.setString(2, programa.getNomPrograma());
            statement.setString(3, programa.getCentroFormacion());
            statement.setString(4, programa.getCoordinacion());
            statement.executeUpdate();
            System.out.println("Programa creado: \n" + programa.toString());
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static List<Programas> findAll() {
        List<Programas> programas = new ArrayList<>();

        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ALL_QUERY);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Programas programa = mapResultSetToPrograma(resultSet);
                programas.add(programa);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programas;
    }

    public static Programas findOne(int idPrograma) {
        Programas programa = null;
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(SELECT_ONE_QUERY);
            statement.setInt(1, idPrograma);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                programa = mapResultSetToPrograma(resultSet);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programa;
    }

    public static void update(Programas programa) {
        try {
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_QUERY);
            statement.setString(1, programa.getNomPrograma());
            statement.setString(2, programa.getCentroFormacion());
            statement.setString(3, programa.getCoordinacion());
            statement.setInt(4, programa.getid_Programa());
            statement.executeUpdate();
            System.out.println("Programa actualizado: " + programa.toString());
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
        Programas deletedPrograma = findOne(id);
        try {
            disableForeignKeyChecks();
            Connection connection = DataBase.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_QUERY);
            statement.setInt(1, id);
            statement.executeUpdate();
            System.out.println("Programa eliminado: " + deletedPrograma.toString());
            statement.close();
            enableForeignKeyChecks();
            connection.close();
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
