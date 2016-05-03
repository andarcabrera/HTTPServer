package TTTApp.Controllers;

import CoreServer.Controllers.AbstractControllerFactory;
import CoreServer.Controllers.Controller;
import TTTApp.Parsers.CookieParser;
import TTTApp.Parsers.GameInfoParser;
import CoreServer.Request.RequestBuilder;
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
    public Controller createController(String controllerName, RequestBuilder request, Response response, String methodsAllowed){
        this.methodsAllowed = methodsAllowed;
        Controller controller = createTTTController(request, response, methodsAllowed, viewFactory, gameInfoParser, cookieParser, game);
        return controller;
    }

    private Controller createTTTController(RequestBuilder request, Response response, String methodsAllowed, AbstractViewFactory viewFactory, GameInfoParser gameInfoParser, CookieParser cookieParser, TTTGame game) {
        return new TTTController(request, response, methodsAllowed, viewFactory, gameInfoParser, cookieParser, game);
    }
}
