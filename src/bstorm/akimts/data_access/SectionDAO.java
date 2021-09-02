package bstorm.akimts.data_access;

import bstorm.akimts.ConnectionFactory;
import bstorm.akimts.model.Section;
import bstorm.akimts.model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SectionDAO implements DAO<Section, Long> {

    // region SINGLETON

    private static SectionDAO instance;
    public static SectionDAO getInstance(){
        return instance == null ? instance = new SectionDAO() : instance;
    }
    private SectionDAO(){}

    // endregion

    @Override
    public boolean insert(Section toInsert) {

        if(toInsert == null)
            throw new IllegalArgumentException("toInsert should not be null");

        try (
                Connection co = ConnectionFactory.getInstance().getConnection();
                Statement stmt = co.createStatement();
        ) {

            return 0 < stmt.executeUpdate("INSERT INTO section " +
                    "VALUES " +
                    "( "+ toInsert.getId() +" , " + toInsert.getName() + " , "+ toInsert.getDelegateId() +" )");

        }
        catch (SQLException ex){
            return false;
        }
    }

    @Override
    public Section getOne(Long aLong) {
        Section s = null;
        try (
            Connection co = ConnectionFactory.getInstance().getConnection();
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM section WHERE section_id = "+ aLong);
        ) {

            if(rs.next())
                s = extract( rs );

        }
        catch (SQLException ex){
            throw new RuntimeException("SQL Error : " + ex.getMessage());
        }
        return s;
    }

    @Override
    public List<Section> getAll() {
        List<Section> list = new ArrayList<>();

        try (
            Connection co = ConnectionFactory.getInstance().getConnection();
            Statement stmt = co.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM section");
        ) {

            while( rs.next() ){
                Section s = extract(rs);
                list.add(s);
            }

        } catch (SQLException ex) {
            throw new RuntimeException("SQL Error : " + ex.getMessage());
        }
        return list;
    }

    @Override
    public boolean update(Section section) {

        if( section == null )
            throw new IllegalArgumentException("section should not be null");

        try (
            Connection co = ConnectionFactory.getInstance().getConnection();
            Statement stmt = co.createStatement();
        ) {

            return 0 < stmt.executeUpdate("UPDATE section " +
                    " SET section_name="+ section.getName() +", delegate_id="+ section.getDelegateId() +
                    " WHERE section_id = "+ section.getId() );

        }
        catch (SQLException ex){
            return false;
        }

    }

    @Override
    public boolean delete(Long id) {

        try (
                Connection co = ConnectionFactory.getInstance().getConnection();
                Statement stmt = co.createStatement();
        ) {

            return 0 < stmt.executeUpdate( "DELETE FROM section WHERE section_id = " + id );

        }
        catch (SQLException ex){
            return false;
        }
    }

    private Section extract(ResultSet rs) throws SQLException {
        Section s = new Section();
        s.setId( rs.getLong("section_id") );
//                s.setId( rs.getLong(1) );
        s.setName( rs.getString("section_name"));
//                s.setName( rs.getString(2) );
        s.setDelegateId( rs.getInt("delegate_id") );
//                s.setDelegateId( rs.getInt(89) );
        return s;
    }
}
