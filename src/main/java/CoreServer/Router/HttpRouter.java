package CoreServer.Router;

import CoreServer.Controllers.AbstractControllerFactory;
import CoreServer.Controllers.Controller;
import CoreServer.Request.Request;
import CoreServer.Response.Response;

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

    public byte[] getResponse(){
        String controllerAction = httpRoute.getControllerAction();
        response = controller.sendResponse(controllerAction);
        return response.responseToBytes();
    }

    public String routeOptions(String action){
        String options = "";
        for (int i=0; i < getRoutes().size(); i++){
            if (getRoutes().get(i).getRouteURL().equals(action)) {
                options += getRoutes().get(i).getRouteMethod() + ",";
            }
        }
        return options;
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
        for (int i = 0; i < httpRoutes.size(); i++){
            if (httpRoutes.get(i).getRequestAction().equals(action)) {
                httpRoute = httpRoutes.get(i);
                break;
            } else if (action.startsWith(httpRoutes.get(i).getRequestAction())){
                httpRoute = httpRoutes.get(i);
            } else {
                httpRoute = new HttpRoute("", "", "");
            }
        }
    }


}
