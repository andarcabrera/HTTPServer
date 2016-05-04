package CobSpecApp.Config;

import CoreServer.Router.HttpRoute;
import CoreServer.Router.Route;
import CoreServer.Router.RoutesConfig;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public class CobspecRoutes implements RoutesConfig {
    ArrayList<Route> routes = new ArrayList<>();
    String sourceDirectory;

    public CobspecRoutes(String sourceDirectory){
        this.sourceDirectory = sourceDirectory;
        addRoutesFromDirectory();
        addRoutes();
    }

    public ArrayList<Route> getRoutes(){
        return routes;
    }

    private void addRoutes(){
        addRoute(new HttpRoute("GET /", "directoryController", "index"));
        addRoute(new HttpRoute("HEAD /", "directoryController", "headOnly"));
        addRoute(new HttpRoute("GET /parameters", "parameterController", "showParamsInBody"));
        addRoute(new HttpRoute("GET /form", "simpleController", "getForm"));
        addRoute(new HttpRoute("POST /form", "simpleController", "postForm"));
        addRoute(new HttpRoute("PUT /form", "simpleController", "putForm"));
        addRoute(new HttpRoute("DELETE /form", "simpleController", "deleteForm"));
        addRoute(new HttpRoute("GET /foobar", "simpleController", "notFound"));
        addRoute(new HttpRoute("HEAD /foobar", "simpleController", "notFound"));
        addRoute(new HttpRoute("GET /method_options", "simpleController", "notFound"));
        addRoute(new HttpRoute("HEAD /method_options", "simpleController", "notFound"));
        addRoute(new HttpRoute("POST /method_options", "simpleController", "notFound"));
        addRoute(new HttpRoute("OPTIONS /method_options", "simpleController", "options"));
        addRoute(new HttpRoute("PUT /method_options", "simpleController", "notFound"));
        addRoute(new HttpRoute("OPTIONS /method_options2", "simpleController", "options"));
        addRoute(new HttpRoute("GET /method_options2", "simpleController", "notFound"));
        addRoute(new HttpRoute("GET /redirect", "redirectController", "redirect"));
        addRoute(new HttpRoute("GET /coffee", "teapotController", "coffee"));
        addRoute(new HttpRoute("GET /tea", "teapotController", "tea"));
        addRoute(new HttpRoute("GET /patch-content.txt", "patchController", "show"));
        addRoute(new HttpRoute("PATCH /patch-content.txt", "patchController", "showPatched"));
        addRoute(new HttpRoute("GET /logs", "basicAuthController", "getSecureResponse"));
    }

    private void addRoutesFromDirectory(){
        File directory = new File(sourceDirectory);
        File[] files = directory.listFiles();
        for (File file : files) {
            String filePath = "" + file;
            String requestAction = "GET " + filePath.substring(sourceDirectory.length(), filePath.length());
            addRoute(new HttpRoute(requestAction, "fileController", "showFileContent"));
        }
    }

    private void addRoute(HttpRoute httpRoute){
        routes.add(httpRoute);
    }
}
