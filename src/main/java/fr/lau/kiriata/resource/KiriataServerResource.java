package fr.lau.kiriata.resource;

import fr.lau.kiriata.dao.MovieDao;
import fr.lau.kiriata.springrestlet.ApplicationContextHolder;
import org.restlet.resource.ServerResource;
import org.springframework.context.ApplicationContext;

public abstract class KiriataServerResource extends ServerResource {

    protected MovieDao movieDao;
    protected ApplicationContext context = ApplicationContextHolder.getContext();

    public KiriataServerResource() {
        movieDao = (MovieDao) context.getBean(MovieDao.DAO_BEAN_NAME);
    }

    public ApplicationContext getApplicationContext() {
        return context;
    }

}
