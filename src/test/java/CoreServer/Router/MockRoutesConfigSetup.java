package CoreServer.Router;

import java.util.ArrayList;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockRoutesConfigSetup implements RoutesConfig {
    ArrayList<Route> routes = new ArrayList<>();

    @Override
    public ArrayList<Route> getRoutes() {
        addRoutes();
        return routes;
    }

    private void addRoutes(){
        addRoute(new MockRoute());
    }

    private void addRoute(Route httpRoute){
        routes.add(httpRoute);
    }

}
