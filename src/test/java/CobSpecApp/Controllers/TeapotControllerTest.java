package CobSpecApp.Controllers;

import CobSpecApp.Controllers.TeapotController;
import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andacabrera29 on 5/2/16.
 */
public class TeapotControllerTest {
    private TeapotController teapotController;
    private Request request;
    private Response response;
    private StringBuffer requestDetails;
    private String methodsAllowed;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        methodsAllowed = "";
        requestDetails = new StringBuffer();
        teapotController = new TeapotController(request, response, methodsAllowed);
    }

    @Test
    public void testCoffee() throws Exception {
        requestDetails.append("method~GET");
        request.buildRequest(requestDetails);

        assertEquals("TeapotI'm a teapot", new String(teapotController.sendResponse("coffee").responseToBytes()));
    }

    @Test
    public void testTea() throws Exception {
        requestDetails.append("method~GET");
        request.buildRequest(requestDetails);

        assertEquals("OK", new String(teapotController.sendResponse("tea").responseToBytes()));
    }
}