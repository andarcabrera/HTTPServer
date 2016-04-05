package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class RedirectControllerTest {
    private RedirectController redirectController;
    private RequestBuilder request;
    private ResponseBuilder response;
    private StringBuffer requestDetails;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        requestDetails = new StringBuffer();
        requestDetails.append("method~GET  url~action");
        request.buildRequest(requestDetails);
        redirectController = new RedirectController(request, response);
    }


    @Test
    public void testGet() throws Exception {
        assertTrue(new String(redirectController.sendResponse().responseToBytes()).startsWith("Redirect"));
        assertTrue(new String(redirectController.sendResponse().responseToBytes()).contains("Location"));
        assertTrue(new String(redirectController.sendResponse().responseToBytes()).contains("http://localhost:5000/"));
    }
}