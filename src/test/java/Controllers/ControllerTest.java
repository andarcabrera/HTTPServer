package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class ControllerTest {
    private Controller controller;
    private RequestBuilder request;
    private ResponseBuilder response;
    private StringBuffer requestDetails;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        requestDetails = new StringBuffer();
        controller = new Controller(request, response) {
            @Override
            public ResponseBuilder sendResponse() {
                return super.sendResponse();
            }
        };
    }

    @Test
    public void testSendResponseGet() throws Exception {
        requestDetails.append("GET bogus request");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponsePut() throws Exception {
        requestDetails.append("PUT bogus request");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponsePost() throws Exception {
        requestDetails.append("POST bogus request");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseDelete() throws Exception {
        requestDetails.append("DELETE bogus request");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseOptions() throws Exception {
        requestDetails.append("OPTIONS bogus request");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseBogus() throws Exception {
        requestDetails.append("BOGUS bogus request");
        request.buildRequest(requestDetails);

        assertEquals("MethodNotAllowed", new String(controller.sendResponse().responseToBytes()));
    }
}