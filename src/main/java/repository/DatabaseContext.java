package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseContext {
    private static String USERNAME = "sa";
    private static String PASSWORD = "12345";
    private static String URL = "jdbc:sqlserver://localhost:1433;databaseName=QLSV";
    private static String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException classNotFoundException) {
            throw new RuntimeException(classNotFoundException);
        }
    }
    public static Connection getConnection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException sqlException) {
            throw new RuntimeException(sqlException);
        }
        return connection;
    }
}
