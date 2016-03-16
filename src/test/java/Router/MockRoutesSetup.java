package Router;

import java.util.HashMap;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockRoutesSetup implements TrackRoutes {
    @Override
    public HashMap<String, String> getRoutes() {
        return routes;
    }

    public MockRoutesSetup(){
        addRoutes();
    }

    private void addRoutes(){
        addRoute("mockAction", "mockController");
    }

    private void addRoute(String action, String controller){
        routes.put(action, controller);
    }

}
