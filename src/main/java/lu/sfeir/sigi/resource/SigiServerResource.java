package lu.sfeir.sigi.resource;

import lu.sfeir.sigi.dao.MovieDao;
import lu.sfeir.sigi.springrestlet.ApplicationContextHolder;
import org.restlet.resource.ServerResource;
import org.springframework.context.ApplicationContext;

public abstract class SigiServerResource extends ServerResource {

    protected MovieDao movieDao;
    protected ApplicationContext context = ApplicationContextHolder.getContext();

    public SigiServerResource() {
        movieDao = (MovieDao) context.getBean(MovieDao.DAO_BEAN_NAME);
    }

    public ApplicationContext getApplicationContext() {
        return context;
    }

}
