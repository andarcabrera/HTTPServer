package Controllers;

import FileMgmt.AccessFile;
import FileMgmt.FileAccess;
import Helpers.Base64ParserAndDecoder;
import Helpers.CookieParser;
import Helpers.GameInfoParser;
import Helpers.Parser;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import TTT.GameRuby;
import TTT.TTTGame;
import Views.AbstractViewFactory;
import Views.ViewFactory;


public class ControllerFactory extends AbstractControllerFactory {
    private FileAccess accessFile = new AccessFile();
    private Base64ParserAndDecoder decoder = new Base64ParserAndDecoder();
    private AbstractViewFactory viewFactory = new ViewFactory();
    private Parser gameInfoParser = new GameInfoParser();
    private Parser cookieParser = new CookieParser();
    private TTTGame game = new GameRuby();
    private String methodsAllowed;

    @Override
    public Controller createController(String controllerName, RequestBuilder request, ResponseBuilder response, String methodsAllowed){
        this.methodsAllowed = methodsAllowed;
        Controller controller = null;

        switch (controllerName) {
            case "simpleController":
                controller = createSimpleController(request, response, methodsAllowed, accessFile);
                break;
            case "directoryController":
                controller = createDirectoryController(request, response, methodsAllowed);
                break;
            case "fileController":
                controller = createFileController(request, response, methodsAllowed, accessFile);
                break;
            case "parameterController":
                controller = createParameterController(request, response, methodsAllowed);
                break;
            case "redirectController":
                controller = createRedirectController(request, response, methodsAllowed);
                break;
            case "patchController":
                controller = createPatchController(request, response, methodsAllowed, accessFile);
                break;
            case "basicAuthController":
                controller = createBasicAuthController(request, response, methodsAllowed, decoder);
                break;
            case "TTTController":
                controller = createTTTController(request, response, methodsAllowed, viewFactory, gameInfoParser, cookieParser, game);
                break;
            case "teapotController":
                controller = createTeapotController(request, response, methodsAllowed);
                break;
            default:
                controller = createDefaultController(request, response, methodsAllowed);
        }
        return controller;
    }
    private Controller createSimpleController(RequestBuilder request, ResponseBuilder response, String methodsAllowed, FileAccess accessFile) {
        return new SimpleController(request, response, methodsAllowed, accessFile);
    }

    private Controller createDirectoryController(RequestBuilder request, ResponseBuilder response, String methodsAllowed) {
        return new DirectoryController(request, response, methodsAllowed);
    }
//
    private Controller createFileController(RequestBuilder request, ResponseBuilder response, String methodsAllowed, FileAccess accessFile) {
        return new FileController(request, response, methodsAllowed, accessFile);
    }

    private Controller createParameterController(RequestBuilder request, ResponseBuilder response, String methodsAllowed) {
        return new ParameterController(request, response, methodsAllowed);
    }

    private Controller createDefaultController(RequestBuilder request, ResponseBuilder response, String methodsAllowed) {
        return new DefaultController(request, response, methodsAllowed);
    }

    private Controller createRedirectController(RequestBuilder request, ResponseBuilder response, String methodsAllowed) {
        return new RedirectController(request, response, methodsAllowed);
    }

    private Controller createPatchController(RequestBuilder request, ResponseBuilder response, String methodsAllowed, FileAccess accessFile) {
        return new PatchController(request, response, methodsAllowed, accessFile);
    }

    private Controller createBasicAuthController(RequestBuilder request, ResponseBuilder response, String methodsAllowed, Base64ParserAndDecoder decoder) {
        return new BasicAuthController(request, response, methodsAllowed, decoder);
    }

    private Controller createTTTController(RequestBuilder request, ResponseBuilder response, String methodsAllowed, AbstractViewFactory viewFactory, Parser gameInfoParser, Parser cookieParser, TTTGame game) {
        return new TTTController(request, response, methodsAllowed, viewFactory, gameInfoParser, cookieParser, game);
    }

    private Controller createTeapotController(RequestBuilder request, ResponseBuilder response, String methodsAllowed) {
        return new TeapotController(request, response, methodsAllowed);
    }
}
