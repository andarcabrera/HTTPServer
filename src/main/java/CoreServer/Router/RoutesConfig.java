package CoreServer.Router;

import CoreServer.Router.Route;

import java.util.ArrayList;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public interface RoutesConfig {
    ArrayList<Route> routes = new ArrayList<>();
    ArrayList<Route> getRoutes();
}
