package Controllers;

import FileMgmt.AccessFile;
import FileMgmt.FileAccess;
import Request.RequestBuilder;
import Response.ResponseBuilder;


public abstract class AbstractControllerFactory {
    private FileAccess accessFile = new AccessFile();

    public Controller createController(String route, RequestBuilder request, ResponseBuilder response){
        Controller controller = null;
        if(route == null){
            controller = createDefaultController(request, response);
            return controller;
        }

        switch (route) {
            case "simpleController":
                controller = createSimpleController(request, response, accessFile);
                break;
            case "directoryController":
                controller = createDirectoryController(request, response);
                break;
            case "fileController":
                controller = createFileController(request, response, accessFile);
                break;
            case "parameterController":
                controller = createParameterController(request, response);
                break;
            case "redirectController":
                controller = createRedirectController(request, response);
                break;
            case "patchController":
                controller = createPatchController(request, response);
                break;
            case "basicAuthController":
                controller = createBasicAuthController(request, response);
                break;
        }
        return controller;
    }

    public abstract Controller createSimpleController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile);
    public abstract Controller createDirectoryController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createFileController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile);
    public abstract Controller createParameterController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createDefaultController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createRedirectController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createPatchController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createBasicAuthController(RequestBuilder request, ResponseBuilder response);
}
