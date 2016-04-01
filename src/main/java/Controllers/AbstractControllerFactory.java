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


public abstract class AbstractControllerFactory {
    private FileAccess accessFile = new AccessFile();
    private Base64ParserAndDecoder decoder = new Base64ParserAndDecoder();
    private AbstractViewFactory viewFactory = new ViewFactory();
    private Parser gameInfoParser = new GameInfoParser();
    private Parser cookieParser = new CookieParser();
    private TTTGame game = new GameRuby();

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

    public abstract Controller createSimpleController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile);
    public abstract Controller createDirectoryController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createFileController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile);
    public abstract Controller createParameterController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createDefaultController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createRedirectController(RequestBuilder request, ResponseBuilder response);
    public abstract Controller createPatchController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile);
    public abstract Controller createBasicAuthController(RequestBuilder request, ResponseBuilder response, Base64ParserAndDecoder decoder);
    public abstract Controller createTTTController(RequestBuilder request, ResponseBuilder response, AbstractViewFactory viewFactory, Parser gameInfoParser, Parser cookieParser, TTTGame game);
}
