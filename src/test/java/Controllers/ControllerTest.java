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
        requestDetails.append("method~GET");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponsePut() throws Exception {
        requestDetails.append("method~PUT");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponsePost() throws Exception {
        requestDetails.append("method~POST");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseDelete() throws Exception {
        requestDetails.append("method~DELETE");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseOptions() throws Exception {
        requestDetails.append("method~OPTIONS");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseBogus() throws Exception {
        requestDetails.append("method~BOGUS");
        request.buildRequest(requestDetails);

        assertEquals("MethodNotAllowed", new String(controller.sendResponse().responseToBytes()));
    }
}