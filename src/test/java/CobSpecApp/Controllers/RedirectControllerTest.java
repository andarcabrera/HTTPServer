package CobSpecApp.Controllers;

import CobSpecApp.Controllers.RedirectController;
import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class RedirectControllerTest {
    private RedirectController redirectController;
    private Request request;
    private Response response;
    private StringBuffer requestDetails;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        requestDetails = new StringBuffer();
        requestDetails.append("method~GET  url~action");
        request.buildRequest(requestDetails);
        redirectController = new RedirectController(request, response, "");
    }


    @Test
    public void testGet() throws Exception {
        assertTrue(new String(redirectController.sendResponse("redirect").responseToBytes()).startsWith("Redirect"));
        assertTrue(new String(redirectController.sendResponse("redirect").responseToBytes()).contains("Location"));
        assertTrue(new String(redirectController.sendResponse("redirect").responseToBytes()).contains("http://localhost:5000/"));
    }
}