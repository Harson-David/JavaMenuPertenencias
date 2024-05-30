package Models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {

    //CASA/ PUERTO POR DEFECTO
    //private static final String URL = "jdbc:mysql://localhost:3306/sede_tic_sena_centro_colombo_aleman_regional_atlantico?useSSL=false&allowPublicKeyRetrieval=true";
    //SENA
    private static final String URL = "jdbc:mysql://localhost:3206/sede_tic_sena_centro_colombo_aleman_regional_atlantico?useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
