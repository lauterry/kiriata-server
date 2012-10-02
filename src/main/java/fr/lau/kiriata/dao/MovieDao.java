package fr.lau.kiriata.dao;

import fr.lau.kiriata.model.Movie;

public interface MovieDao extends GenericDao<Movie, Long> {

    public static final String DAO_BEAN_NAME = "movieDao";

}