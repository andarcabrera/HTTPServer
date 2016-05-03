package TTTApp.Controllers;

import CoreServer.Controllers.AbstractControllerFactory;
import CoreServer.Controllers.Controller;
import CoreServer.Controllers.DefaultController;
import TTTApp.Parsers.CookieParser;
import TTTApp.Parsers.GameInfoParser;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import TTTApp.TTTGame.GameRuby;
import TTTApp.TTTGame.TTTGame;
import TTTApp.Views.AbstractViewFactory;
import TTTApp.Views.ViewFactory;

/**
 * Created by andacabrera29 on 5/2/16.
 */
public class TTTControllerFactory extends AbstractControllerFactory {
    private String methodsAllowed;
    private AbstractViewFactory viewFactory = new ViewFactory();
    private GameInfoParser gameInfoParser = new GameInfoParser();
    private CookieParser cookieParser = new CookieParser();
    private TTTGame game = new GameRuby();

    @Override
    public Controller createController(String controllerName, Request request, Response response, String methodsAllowed){
        this.methodsAllowed = methodsAllowed;
        Controller controller = null;

        switch (controllerName) {
            case "TTTController":
                controller = createTTTController(request, response, methodsAllowed, viewFactory, gameInfoParser, cookieParser, game);
                break;
            default:
                controller = createDefaultController(request, response, methodsAllowed);
        }
        return controller;
    }

    private Controller createTTTController(Request request, Response response, String methodsAllowed, AbstractViewFactory viewFactory, GameInfoParser gameInfoParser, CookieParser cookieParser, TTTGame game) {
        return new TTTController(request, response, methodsAllowed, viewFactory, gameInfoParser, cookieParser, game);
    }

    private Controller createDefaultController(Request request, Response response, String methodsAllowed) {
        return new DefaultController(request, response, methodsAllowed);
    }
}
