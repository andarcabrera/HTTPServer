package TTTApp.Config;

import CoreServer.Router.HttpRoute;
import CoreServer.Router.Route;
import CoreServer.Router.RoutesConfig;

import java.util.ArrayList;

/**
 * Created by andacabrera29 on 5/2/16.
 */
public class TTTRoutes implements RoutesConfig {
    public TTTRoutes(){
        addRoutes();
    }

    public ArrayList<Route> getRoutes(){
        return routes;
    }

    private void addRoutes(){
        addRoute(new HttpRoute("GET /ttt", "TTTController", "tttHomePage"));
        addRoute(new HttpRoute("POST /games", "TTTController", "startGame"));
        addRoute(new HttpRoute("PUT /make_move/", "TTTController", "makeMove"));
    }

    private void addRoute(HttpRoute httpRoute){
        routes.add(httpRoute);
    }
}
