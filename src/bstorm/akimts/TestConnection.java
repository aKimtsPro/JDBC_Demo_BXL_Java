package bstorm.akimts;

import java.sql.Connection;
import java.sql.SQLException;

public class TestConnection {

    public static void main(String[] args) {

        System.out.println("Trying the connection");
        try (Connection co = ConnectionFactory.getConnection() ){
            System.out.println("Connection success");
        }
        catch ( SQLException ex ){
            System.out.println("Connection failed : " + ex.getMessage());
        }

    }

}
