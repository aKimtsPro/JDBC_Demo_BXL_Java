package bstorm.akimts.data_access;

import bstorm.akimts.model.Section;

import java.util.List;

public interface DAO<T, ID> {

    // CREATE
    boolean insert(T toInsert);

    // READ
    T getOne( ID id );
    List<T> getAll() throws Exception;

    // UPDATE
    boolean update( T section );

    // DELETE
    boolean delete( ID id );

}
