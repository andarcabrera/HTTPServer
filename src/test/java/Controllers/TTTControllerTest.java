package Controllers;

import Helpers.CookieParser;
import Helpers.GameInfoParser;
import Helpers.Parser;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import TTT.GameRuby;
import TTT.MockGameRuby;
import TTT.TTTGame;
import Views.AbstractViewFactory;
import Views.ViewFactory;
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
    private RequestBuilder request;
    private ResponseBuilder response;
    private StringBuffer requestDetails;
    private AbstractViewFactory viewFactory;
    private Parser gameInfoParser;
    private Parser cookieParser;
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
        controller = new TTTController(request, response, viewFactory, gameInfoParser, cookieParser, game);
    }

    @Test
    public void testGet() throws Exception {
        requestDetails.append("GET action");
        request.buildRequest(requestDetails);

        assertTrue(new String(controller.sendResponse().responseToBytes()).startsWith("OK"));
        assertTrue(new String(controller.sendResponse().responseToBytes()).contains("Chose your adventure. May the force of minimax be with you!"));
        assertTrue(new String(controller.sendResponse().responseToBytes()).contains("player-details"));
    }

    @Test
    public void testPost() throws Exception {
        requestDetails.append("POST action size=9&player1_type=human&player1_marker=M&player1_name=Player1&player2_type=human&player2_marker=N&player2_name=Player2");
        request.buildRequest(requestDetails);

        assertTrue(new String(controller.sendResponse().responseToBytes()).startsWith("OK"));
        assertTrue(new String(controller.sendResponse().responseToBytes()).contains("Click to make your move"));
    }

    @Test
    public void testPut() throws Exception {
        requestDetails.append("POST action size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2");
        request.buildRequest(requestDetails);
        requestDetails.append("PUT /make_move/2 version");
        request.buildRequest(requestDetails);
        System.out.println(game.getMarkers()[0]);
        assertTrue(new String(controller.sendResponse().responseToBytes()).startsWith("OK"));
        assertTrue(new String(controller.sendResponse().responseToBytes()).contains("Click to make your move"));
        assertTrue(new String(controller.sendResponse().responseToBytes()).contains("M"));

    }
}