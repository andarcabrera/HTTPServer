package Router;

import Controllers.AbstractControllerFactory;
import Controllers.Controller;
import Request.RequestBuilder;
import Response.ResponseBuilder;

import java.util.ArrayList;


public class Router implements RouterStrategy{
    ResponseBuilder response;
    RequestBuilder request;
    TrackRoutes routesSetup;
    AbstractControllerFactory controllerFactory;
    Controller controller;
    Route httpRoute = new HttpRoute("none", "none", "none");

    public Router(AbstractControllerFactory controllerFactory, ResponseBuilder response, TrackRoutes routesSetup){
        this.controllerFactory = controllerFactory;
        this.response = response;
        this.routesSetup = routesSetup;
    }

    public void route(RequestBuilder request) {
        this.request = request;
        String action = request.getRequestAction();
        controller = createController(action, request, response);
    }

    public byte[] getResponse(){
        String controllerAction = httpRoute.getControllerAction();
        System.out.println("Controller " + controller);
        response = controller.sendResponse(controllerAction);
        return response.responseToBytes();
    }

    private Controller createController(String action, RequestBuilder request, ResponseBuilder response){
        setHttpRoute(action);
        String controllerName = httpRoute.getControllerName();
        return controllerFactory.createController(controllerName, request, response, routesSetup.routeOptions(request.getUrl()));
    }

    private ArrayList<Route> getRoutes(){
        return routesSetup.getRoutes();
    }

    private void setHttpRoute(String action){
        ArrayList<Route> httpRoutes = getRoutes();
        for (int i = 0; i < httpRoutes.size(); i++){
            if (httpRoutes.get(i).getRequestAction().equals(action)) {
                httpRoute = httpRoutes.get(i);
                break;
            } else if (action.startsWith(httpRoutes.get(i).getRequestAction())){
                httpRoute = httpRoutes.get(i);
            }
        }
    }


}
