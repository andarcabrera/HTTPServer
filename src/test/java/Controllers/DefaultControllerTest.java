package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class DefaultControllerTest {
    private DefaultController defaultController;
    private RequestBuilder request;
    private ResponseBuilder response;
    private StringBuffer requestDetails;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        requestDetails = new StringBuffer();
        defaultController = new DefaultController(request, response);
    }

    @Test
    public void testGet() throws Exception {
        requestDetails.append("method~GET");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(defaultController.sendResponse().responseToBytes()));
    }

    @Test
    public void testPost() throws Exception {
        requestDetails.append("method~POST");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(defaultController.sendResponse().responseToBytes()));
    }

    @Test
    public void testPut() throws Exception {
        requestDetails.append("method~PUT");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(defaultController.sendResponse().responseToBytes()));
    }
}