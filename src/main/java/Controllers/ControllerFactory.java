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

    @Override
    public Controller createController(String controllerName, RequestBuilder request, ResponseBuilder response){
        Controller controller = null;
        if(controllerName == null){
            controller = createDefaultController(request, response);
            return controller;
        }

        switch (controllerName) {
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
                controller = createPatchController(request, response, accessFile);
                break;
            case "basicAuthController":
                controller = createBasicAuthController(request, response, decoder);
                break;
            case "TTTController":
                controller = createTTTController(request, response, viewFactory, gameInfoParser, cookieParser, game);
                break;
        }
        return controller;
    }
    private Controller createSimpleController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile) {
        return new SimpleController(request, response, accessFile);
    }

    private Controller createDirectoryController(RequestBuilder request, ResponseBuilder response) {
        return new DirectoryController(request, response);
    }

    private Controller createFileController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile) {
        return new FileController(request, response, accessFile);
    }

    private Controller createParameterController(RequestBuilder request, ResponseBuilder response) {
        return new ParameterController(request, response);
    }

    private Controller createDefaultController(RequestBuilder request, ResponseBuilder response) {
        return new DefaultController(request, response);
    }

    private Controller createRedirectController(RequestBuilder request, ResponseBuilder response) {
        return new RedirectController(request, response);
    }

    private Controller createPatchController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile) {
        return new PatchController(request, response, accessFile);
    }

    private Controller createBasicAuthController(RequestBuilder request, ResponseBuilder response, Base64ParserAndDecoder decoder) {
        return new BasicAuthController(request, response, decoder);
    }

    private Controller createTTTController(RequestBuilder request, ResponseBuilder response, AbstractViewFactory viewFactory, Parser gameInfoParser, Parser cookieParser, TTTGame game) {
        return new TTTController(request, response, viewFactory, gameInfoParser, cookieParser, game);
    }
}
