package lu.sfeir.sigi;

import lu.sfeir.sigi.resource.MovieResource;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

public class KiriataApplication extends Application {

    public synchronized Restlet createInboundRoot() {

        Router rootRouter = new Router(getContext());
        rootRouter.attach("/movies", MovieResource.class);
        return rootRouter;
    }

}