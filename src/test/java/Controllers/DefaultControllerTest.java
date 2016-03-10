package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class DefaultControllerTest {
    private DefaultController defaultController;

    @Test
    public void testGet() throws Exception {
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "GET");
        RequestBuilder request = new MockRequest(requestDetails);
        ResponseBuilder response = new MockResponse();
        defaultController = new DefaultController(request, response);
        assertEquals("PageNotFound", new String(defaultController.sendResponse().responseToBytes()));
    }

    @Test
    public void testPost() throws Exception {

    }

    @Test
    public void testPut() throws Exception {

    }
}