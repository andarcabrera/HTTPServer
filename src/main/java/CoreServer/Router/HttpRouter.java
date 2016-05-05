package CoreServer.Router;

import CoreServer.Controllers.AbstractControllerFactory;
import CoreServer.Controllers.Controller;
import CoreServer.Request.Request;
import CoreServer.Response.Response;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;


public class HttpRouter implements RouterStrategy{
    Response response;
    Request request;
    RoutesConfig routesSetup;
    AbstractControllerFactory controllerFactory;
    Controller controller;
    Route httpRoute;

    public HttpRouter(AbstractControllerFactory controllerFactory, Response response, RoutesConfig routesSetup){
        this.controllerFactory = controllerFactory;
        this.response = response;
        this.routesSetup = routesSetup;
    }

    public void route(Request request) {
        this.request = request;
        String action = request.getRequestAction();
        controller = createController(action, request, response);
    }

    public byte[] getResponse() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        String controllerAction = httpRoute.getControllerAction();
        response = controller.sendResponse(controllerAction);
        return response.responseToBytes();
    }

    private String routeOptions(String requestURL){
        String options = "";
        int existingRoutes = getRoutes().size();
        for (int i=0; i < existingRoutes; i++){
            if (getRoutes().get(i).getRouteURL().equals(requestURL)) {
                options += getRoutes().get(i).getRouteMethod() + ",";
            }
        }
        return options + "OPTIONS";
    }

    private Controller createController(String action, Request request, Response response){
        setHttpRoute(action);
        String controllerName = httpRoute.getControllerName();
        return controllerFactory.createController(controllerName, request, response, routeOptions(request.getUrl()));
    }

    private ArrayList<Route> getRoutes(){
        return routesSetup.getRoutes();
    }

    private void setHttpRoute(String action){

        ArrayList<Route> httpRoutes = getRoutes();
        for (Route httpRoute1 : httpRoutes) {
            if (httpRoute1.getRequestAction().equals(action)) {
                httpRoute = httpRoute1;
                break;
            } else if (action.startsWith(httpRoute1.getRequestAction())) {
                httpRoute = httpRoute1;
            } else if (httpRoute1.getRouteURL().equals(request.getUrl()) && !routeOptions(request.getUrl()).contains(request.getMethod())) {
                httpRoute = new HttpRoute(request.getRequestAction(), "defaultController", "methodNotAllowed");
                break;
            } else if (request.getMethod().equals("OPTIONS")){
                httpRoute = new HttpRoute(request.getRequestAction(), "simpleController", "options");
            } else {
                httpRoute = new HttpRoute(request.getRequestAction(), "defaultController", "pageNotFound");
            }
        }
    }


}
