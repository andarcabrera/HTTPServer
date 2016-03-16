package Router;

import Controllers.AbstractControllerFactory;
import Controllers.Controller;
import Request.RequestBuilder;
import Response.ResponseBuilder;

import java.util.HashMap;


public class Router implements RouterStrategy{
    ResponseBuilder response;
    TrackRoutes routesSetup;
    AbstractControllerFactory controllerFactory;
    Controller controller;

    public Router(AbstractControllerFactory controllerFactory, ResponseBuilder response, TrackRoutes routesSetup){
        this.controllerFactory = controllerFactory;
        this.response = response;
        this.routesSetup = routesSetup;
    }

    public void route(RequestBuilder request) {
        String action = request.getUrl();
        controller = createController(action, request, response);
        System.out.println(controller.getClass());
    }

    public byte[] getResponse(){
        response =  controller.sendResponse();
        return response.responseToBytes();
    }

    private Controller createController(String action, RequestBuilder request, ResponseBuilder response){
        String controllerName = getRoutes().get(action);
        return controllerFactory.createController(controllerName, request, response);
    }

    private HashMap<String, String> getRoutes(){
        return routesSetup.getRoutes();
    }
}
