package lu.sfeir.sigi.dao;

import lu.sfeir.sigi.model.Movie;

public interface MovieDao extends GenericDao<Movie, Long> {

    public static final String DAO_BEAN_NAME = "movieDao";

}