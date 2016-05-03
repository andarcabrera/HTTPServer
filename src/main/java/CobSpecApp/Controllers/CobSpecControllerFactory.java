package CobSpecApp.Controllers;

import CoreServer.Controllers.AbstractControllerFactory;
import CoreServer.Controllers.Controller;
import CoreServer.Controllers.DefaultController;
import CoreServer.FileMgmt.AccessFile;
import CoreServer.FileMgmt.FileAccess;
import CobSpecApp.Parsers.Base64ParserAndDecoder;
import CoreServer.Request.Request;
import CoreServer.Response.Response;

public class CobSpecControllerFactory extends AbstractControllerFactory {
    private FileAccess accessFile = new AccessFile();
    private Base64ParserAndDecoder decoder = new Base64ParserAndDecoder();
    private String sourceDirectory;
    private String methodsAllowed;

    public CobSpecControllerFactory(String sourceDirectory){
        this.sourceDirectory = sourceDirectory;
    }

    @Override
    public Controller createController(String controllerName, Request request, Response response, String methodsAllowed){
        this.methodsAllowed = methodsAllowed;
        Controller controller = null;

        switch (controllerName) {
            case "simpleController":
                controller = createSimpleController(request, response, methodsAllowed, accessFile, sourceDirectory);
                break;
            case "directoryController":
                controller = createDirectoryController(request, response, methodsAllowed, sourceDirectory);
                break;
            case "fileController":
                controller = createFileController(request, response, methodsAllowed, accessFile, sourceDirectory);
                break;
            case "parameterController":
                controller = createParameterController(request, response, methodsAllowed);
                break;
            case "redirectController":
                controller = createRedirectController(request, response, methodsAllowed);
                break;
            case "patchController":
                controller = createPatchController(request, response, methodsAllowed, accessFile, sourceDirectory);
                break;
            case "basicAuthController":
                controller = createBasicAuthController(request, response, methodsAllowed, decoder);
                break;
            case "teapotController":
                controller = createTeapotController(request, response, methodsAllowed);
                break;
            case "defaultController":
                controller = createDefaultController(request, response, methodsAllowed);
                break;
            default:
                controller = createDefaultController(request, response, methodsAllowed);
        }
        return controller;
    }
    private Controller createSimpleController(Request request, Response response, String methodsAllowed, FileAccess accessFile, String sourceDirectory) {
        return new SimpleController(request, response, methodsAllowed, accessFile, sourceDirectory);
    }

    private Controller createDirectoryController(Request request, Response response, String methodsAllowed, String sourceDirectory) {
        return new DirectoryController(request, response, methodsAllowed, sourceDirectory);
    }

    private Controller createFileController(Request request, Response response, String methodsAllowed, FileAccess accessFile, String sourceDirectory) {
        return new FileController(request, response, methodsAllowed, accessFile, sourceDirectory);
    }

    private Controller createParameterController(Request request, Response response, String methodsAllowed) {
        return new ParameterController(request, response, methodsAllowed);
    }

    private Controller createDefaultController(Request request, Response response, String methodsAllowed) {
        return new DefaultController(request, response, methodsAllowed);
    }

    private Controller createRedirectController(Request request, Response response, String methodsAllowed) {
        return new RedirectController(request, response, methodsAllowed);
    }

    private Controller createPatchController(Request request, Response response, String methodsAllowed, FileAccess accessFile, String sourceDirectory) {
        return new PatchController(request, response, methodsAllowed, accessFile, sourceDirectory);
    }

    private Controller createBasicAuthController(Request request, Response response, String methodsAllowed, Base64ParserAndDecoder decoder) {
        return new BasicAuthController(request, response, methodsAllowed, decoder);
    }

    private Controller createTeapotController(Request request, Response response, String methodsAllowed) {
        return new TeapotController(request, response, methodsAllowed);
    }
}
