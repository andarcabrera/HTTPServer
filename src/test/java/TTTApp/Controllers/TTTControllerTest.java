package TTTApp.Controllers;

import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import TTTApp.Parsers.CookieParser;
import TTTApp.Parsers.GameInfoParser;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import TTTApp.TTTGame.MockGameRuby;
import TTTApp.TTTGame.TTTGame;
import TTTApp.Views.AbstractViewFactory;
import TTTApp.Views.ViewFactory;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by andacabrera29 on 3/30/16.
 */
public class TTTControllerTest {
    private TTTController controller;
    private Request request;
    private Response response;
    private StringBuffer requestDetails;
    private AbstractViewFactory viewFactory;
    private GameInfoParser gameInfoParser;
    private CookieParser cookieParser;
    private TTTGame game;
    private Map<String, String[]> gameInfo;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        requestDetails = new StringBuffer();
        viewFactory = new ViewFactory();
        gameInfoParser = new GameInfoParser();
        cookieParser = new CookieParser();
        gameInfo= new HashMap<>();
        String[] size = new String[] {"9"};
        String[] gameOver = new String[] {"false"};
        String[] markers = new String[] {"M", "N"};
        String [] board = new String[] {"0", "M", "2", "3", "4", "5", "6", "7", "8"};
        gameInfo.put("size", size);
        gameInfo.put("gameOver", gameOver);
        gameInfo.put("markers", markers);
        gameInfo.put("board", board);
        game = new MockGameRuby(gameInfo);
        controller = new TTTController(request, response, "", viewFactory, gameInfoParser, cookieParser, game);
    }

    @Test
    public void testHomePage() throws Exception {
        requestDetails.append("method~GET");
        request.buildRequest(requestDetails);

        assertTrue(new String(controller.sendResponse("tttHomePage").responseToBytes()).startsWith("OK"));
        assertTrue(new String(controller.sendResponse("tttHomePage").responseToBytes()).contains("Chose your adventure. May the force of minimax be with you!"));
        assertTrue(new String(controller.sendResponse("tttHomePage").responseToBytes()).contains("player-details"));
    }

    @Test
    public void testStartGame() throws Exception {
        requestDetails.append("method~POST  rawBody~size=9&player1_type=human&player1_marker=M&player1_name=Player1&player2_type=human&player2_marker=N&player2_name=Player2");
        request.buildRequest(requestDetails);

        assertTrue(new String(controller.sendResponse("startGame").responseToBytes()).startsWith("OK"));
        assertTrue(new String(controller.sendResponse("startGame").responseToBytes()).contains("Click to make your move"));
    }

    @Test
    public void testMakeMove() throws Exception {
        requestDetails.append("method~PUT  url~/make_move/2  Cookie~game_info=:size=9&player1_type=human&player1_marker=M&player1_name=Player1&player2_type=human&player2_marker=N&player2_name=Player2;");
        request.buildRequest(requestDetails);

        assertTrue(new String(controller.sendResponse("makeMove").responseToBytes()).startsWith("OK"));
        assertTrue(new String(controller.sendResponse("makeMove").responseToBytes()).contains("Click to make your move"));
        assertTrue(new String(controller.sendResponse("makeMove").responseToBytes()).contains("M"));

    }
}