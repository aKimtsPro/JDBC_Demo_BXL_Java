package bstorm.akimts.exo;

import bstorm.akimts.ConnectionFactory;
import bstorm.akimts.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ExoEtudiant {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Veuillez entrer l'id à récupérer");
        long id = sc.nextLong();

        try( Connection co = ConnectionFactory.getConnection() ){

            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM student WHERE student_id = " + id);

            Student student = null;
            if( rs.next() ){

                 student = new Student(
                        rs.getLong(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getTimestamp(4) == null ? null : rs.getTimestamp(4).toLocalDateTime(),
                        rs.getString(5),
                        rs.getLong(6),
                        rs.getInt(7),
                        rs.getString(8)
                );

                System.out.println("--- STUDENT ---");
                System.out.println("\tid: " + student.getId() );
                System.out.println("\tfirstname: " + student.getFirstname() );
                System.out.println("\tlastname: " + student.getLastname() );
                System.out.println("\tbdate: " + student.getBirthdate() );
                System.out.println("\tlogin: " + student.getLogin() );
                System.out.println("\tsectionId: " + student.getSectionId() );
                System.out.println("\tyearResult: " + student.getYearResult() );
                System.out.println("\tcourseId: " + student.getCourseId() );

            }
            else
                System.out.println("PAS D'ETUDIANT AVEC CET ID");

        }
        catch( SQLException ex ){
            ex.printStackTrace();
        }

    }
}
