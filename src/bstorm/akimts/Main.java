package bstorm.akimts;

import bstorm.akimts.model.Section;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try ( Connection co = ConnectionFactory.getConnection() ) {

            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM section");

            while( rs.next() ){

                Section s = new Section();
                s.setId( rs.getLong("section_id") );
//                s.setId( rs.getLong(1) );
                s.setName( rs.getString("section_name"));
//                s.setName( rs.getString(2) );
                s.setDelegateId( rs.getInt("delegate_") );
//                s.setDelegateId( rs.getInt(89) );

                System.out.println( s.getId() + " " +
                        s.getName() + " " +
                        s.getDelegateId());
            }

        } catch (SQLException throwables) {
            System.out.println("connection failed : "+ throwables.getMessage() + " CODE: " + throwables.getErrorCode() );
        }

    }

}
