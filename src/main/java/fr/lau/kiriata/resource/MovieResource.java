package fr.lau.kiriata.resource;

import fr.lau.kiriata.model.Movie;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.resource.Delete;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.Put;

import java.io.IOException;
import java.io.Reader;
import java.util.List;
import java.util.Map;

public class MovieResource extends KiriataServerResource {

    @Get
	public JacksonRepresentation<List<Movie>> fetchOwnedMovies() {
        List<Movie> movies = movieDao.readAll();
        JacksonRepresentation<List<Movie>> jsonRepresentation = new JacksonRepresentation<List<Movie>>(movies);
		return jsonRepresentation;
	}

	@Post
	public void addMovie(JacksonRepresentation<Movie> jsonRepresentation) throws IOException {
        Reader reader = jsonRepresentation.getReader();
        Movie movie = jsonRepresentation.getObjectMapper().readValue(reader, Movie.class);
        if (movie.getId() == null) {
            movie.setRate(-1);
        }
        movieDao.saveOrUpdate(movie);
	}

    @Put
    public void updateMovie(JacksonRepresentation<Movie> jsonRepresentation) throws IOException {
        Reader reader = jsonRepresentation.getReader();
        Movie movie = jsonRepresentation.getObjectMapper().readValue(reader, Movie.class);
        movieDao.saveOrUpdate(movie);
    }

    @Delete
    public void deleteDog() {
        Map<String, Object> attributes = getRequest().getAttributes();
        String id = (String) attributes.get("dogId");
        Movie movie = movieDao.read(Long.valueOf(id));
        movieDao.delete(movie);
    }
}
