package Router;

import java.util.HashMap;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public class RoutesSetup {
    private HashMap<String, String> routes = new HashMap<>();

    public RoutesSetup(){
        addRoutes();
    }

    public HashMap<String, String> getRoutes(){
        return routes;
    }

    private void addRoutes(){
        addRoute("/", "simpleController");
        addRoute("/file1", "simpleController");
        addRoute("/foobar", "simpleController");
        addRoute("/image.jpeg", "simpleController");
        addRoute("/image.png", "simpleController");
        addRoute("/image.gif", "simpleController");
        addRoute("/parameters", "simpleController");
        addRoute("/form", "simpleController");
    }

    private void addRoute(String action, String controller){
        routes.put(action, controller);
    }
}
