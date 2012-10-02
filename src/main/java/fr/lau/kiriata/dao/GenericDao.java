package fr.lau.kiriata.dao;

import java.io.Serializable;
import java.util.List;

public interface GenericDao<T, PK extends Serializable> {
    T read(PK id);
    List<T> readAll();
    T load (PK id);
    void bulkUpdate(String query, Object[] params);
    void saveOrUpdate(T transientObject);
    void delete(T persistentObject);
}
