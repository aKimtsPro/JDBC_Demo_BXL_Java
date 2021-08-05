package bstorm.akimts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String URL = "jdbc:mysql://localhost:3308/dbslide";
    private static final String USER = "root";
    private static final String PSWD = "";

    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PSWD);
        } catch (SQLException throwables) {
            throw new RuntimeException("Connection impossible : " + throwables.getMessage());
        }
    }

}
