package Router;

import java.util.HashMap;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public class RoutesSetup implements TrackRoutes{

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
        addRoute("/redirect", "redirectController");
        addRoute("/patch-content.txt", "patchController");
        addRoute("/logs", "basicAuthController");
        addRoute("/ttt", "TTTController");
        addRoute("/games", "TTTController");
        addRoute("/make_move/0", "TTTController");
        addRoute("/make_move/1", "TTTController");
        addRoute("/make_move/2", "TTTController");
        addRoute("/make_move/3", "TTTController");
        addRoute("/make_move/4", "TTTController");
        addRoute("/make_move/5", "TTTController");
        addRoute("/make_move/6", "TTTController");
        addRoute("/make_move/7", "TTTController");
        addRoute("/make_move/8", "TTTController");
        addRoute("/make_move/9", "TTTController");
        addRoute("/make_move/10", "TTTController");
        addRoute("/make_move/11", "TTTController");
        addRoute("/make_move/12", "TTTController");
        addRoute("/make_move/13", "TTTController");
        addRoute("/make_move/14", "TTTController");
        addRoute("/make_move/15", "TTTController");
    }

    private void addRoute(String action, String controller){
        routes.put(action, controller);
    }
}
