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
        addRoute("/", "directoryController");
        addRoute("/file1", "fileController");
        addRoute("/image.jpeg", "fileController");
        addRoute("/image.png", "fileController");
        addRoute("/image.gif", "fileController");
        addRoute("/parameters", "parameterController");
        addRoute("/form", "simpleController");
        addRoute("/text-file.txt", "fileController");
        addRoute("/partial_content.txt", "fileController");
        addRoute("/method_options", "simpleController");
    }

    private void addRoute(String action, String controller){
        routes.put(action, controller);
    }
}
