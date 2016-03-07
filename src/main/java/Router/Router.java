package Router;

import Controllers.Controller;
import Controllers.ControllerFactory;
import Request.Request;
import Request.RequestBuilder;
import Response.HttpServerResponse;
import Response.ResponseBuilder;

import java.util.HashMap;


public class Router {
    HttpServerResponse response = new HttpServerResponse();
    RoutesSetup routesSetup = new RoutesSetup();
    ControllerFactory controllerFactory = new ControllerFactory();
    Controller controller;


    public void route(Request request) {
        String action = request.getUrl();
        controller = createController(action, request, response);
    }

    private Controller createController(String action, RequestBuilder request, ResponseBuilder response){
        String controllerName = getRoutes().get(action);
        return controllerFactory.createController(controllerName, request, response);
    }


    public byte[] getResponse(){
        return controller.sendResponse();
    }

    private HashMap<String, String> getRoutes(){
        return routesSetup.getRoutes();
    }
}
