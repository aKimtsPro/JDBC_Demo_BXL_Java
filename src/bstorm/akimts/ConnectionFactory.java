package bstorm.akimts;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ConnectionFactory instance;
    public static ConnectionFactory getInstance(){
        if(instance == null){
            instance = new ConnectionFactory();
        }
        return instance;
    }
    private ConnectionFactory() {}

    private static final String URL = "jdbc:mysql://localhost:3308/dbslide";
    private static final String USER = "root";
    private static final String PSWD = "";

    public Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USER,PSWD);
        } catch (SQLException throwables) {
            throw new RuntimeException("Connection impossible : " + throwables.getMessage());
        }
    }

}
