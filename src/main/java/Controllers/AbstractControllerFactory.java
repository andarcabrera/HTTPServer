package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;

/**
 * Created by andacabrera29 on 3/7/16.
 */
public abstract class AbstractControllerFactory {

    public Controller createController(String route, RequestBuilder request, ResponseBuilder response){
        Controller controller = null;
        switch (route) {
            case "simpleController":
                controller = createSimpleController(request, response);
                break;
        }
        return controller;
    }
    public abstract Controller createSimpleController(RequestBuilder request, ResponseBuilder response);
}
