package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class RedirectControllerTest {
    private RedirectController redirectController;
    private RequestBuilder request;
    private ResponseBuilder response;

    @Before
    public void setUp(){
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "GET");
        request = new MockRequest(requestDetails);
        response = new MockResponse();
        redirectController = new RedirectController(request, response);
    }


    @Test
    public void testGet() throws Exception {
        assertTrue(new String(redirectController.sendResponse().responseToBytes()).startsWith("Redirect"));
        assertTrue(new String(redirectController.sendResponse().responseToBytes()).contains("Location"));
        assertTrue(new String(redirectController.sendResponse().responseToBytes()).contains("http://localhost:5000/"));
    }
}