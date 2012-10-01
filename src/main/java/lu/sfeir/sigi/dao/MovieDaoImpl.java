package lu.sfeir.sigi.dao;

import lu.sfeir.sigi.model.Movie;

public class MovieDaoImpl extends GenericDaoImpl<Movie, Long> implements MovieDao {

	public MovieDaoImpl() {
		super(Movie.class);
	}

}