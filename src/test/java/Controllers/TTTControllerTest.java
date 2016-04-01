package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.AbstractViewFactory;
import Views.ViewFactory;
import org.junit.Before;
import org.junit.Test;

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

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        requestDetails = new StringBuffer();
        viewFactory = new ViewFactory();
        controller = new TTTController(request, response, viewFactory);
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
        requestDetails.append("POST action size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2");
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

        assertTrue(new String(controller.sendResponse().responseToBytes()).startsWith("OK"));
        assertTrue(new String(controller.sendResponse().responseToBytes()).contains("Click to make your move"));

    }
}