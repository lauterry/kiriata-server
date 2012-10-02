package fr.lau.kiriata.dao;

import fr.lau.kiriata.model.Movie;

public class MovieDaoImpl extends GenericDaoImpl<Movie, Long> implements MovieDao {

	public MovieDaoImpl() {
		super(Movie.class);
	}

}