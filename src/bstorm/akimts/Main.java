package bstorm.akimts;

import bstorm.akimts.data_access.DAO;
import bstorm.akimts.data_access.SectionDAO;
import bstorm.akimts.model.Section;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        DAO<Section, Long> dao = new SectionDAO();
//        System.out.println( dao.insert(new Section(89, null, 1 )));
        System.out.println( dao.delete(89L) );

    }

}
