package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public abstract class AbstractControllerFactory {

    public Controller createController(String route, RequestBuilder request, ResponseBuilder response){
        Controller controller = null;
        if(route == null){
            controller = createDefaultController(request, response);
            return controller;
        }

        switch (route) {
            case "simpleController":
                controller = createSimpleController(request, response);
                break;
            case "directoryController":
                controller = createDirectoryController(request, response);
                break;
            case "fileController":
                controller = createFileController(request, response);
                break;
            case "parameterController":
                controller = createParameterController(request, response);
                break;
        }
        return controller;
    }

    public abstract Controller createSimpleController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createDirectoryController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createFileController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createParameterController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createDefaultController(RequestBuilder request, ResponseBuilder response);
}
