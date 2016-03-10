package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;


public class ControllerTest {
    private Controller controller;


    @Test
    public void testSendResponseGet() throws Exception {
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "GET");
        RequestBuilder request = new MockRequest(requestDetails);
        ResponseBuilder response = new MockResponse();
        controller = new Controller(request, response) {
            @Override
            public ResponseBuilder sendResponse() {
                return super.sendResponse();
            }
        };
        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponsePut() throws Exception {
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "PUT");
        RequestBuilder request = new MockRequest(requestDetails);
        ResponseBuilder response = new MockResponse();
        controller = new Controller(request, response) {
            @Override
            public ResponseBuilder sendResponse() {
                return super.sendResponse();
            }
        };
        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponsePost() throws Exception {
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "POST");
        RequestBuilder request = new MockRequest(requestDetails);
        ResponseBuilder response = new MockResponse();
        controller = new Controller(request, response) {
            @Override
            public ResponseBuilder sendResponse() {
                return super.sendResponse();
            }
        };
        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseDelete() throws Exception {
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "DELETE");
        RequestBuilder request = new MockRequest(requestDetails);
        ResponseBuilder response = new MockResponse();
        controller = new Controller(request, response) {
            @Override
            public ResponseBuilder sendResponse() {
                return super.sendResponse();
            }
        };
        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseOptions() throws Exception {
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "OPTIONS");
        RequestBuilder request = new MockRequest(requestDetails);
        ResponseBuilder response = new MockResponse();
        controller = new Controller(request, response) {
            @Override
            public ResponseBuilder sendResponse() {
                return super.sendResponse();
            }
        };
        assertEquals("PageNotFound", new String(controller.sendResponse().responseToBytes()));
    }

    @Test
    public void testSendResponseBogus() throws Exception {
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "BOG");
        RequestBuilder request = new MockRequest(requestDetails);
        ResponseBuilder response = new MockResponse();
        controller = new Controller(request, response) {
            @Override
            public ResponseBuilder sendResponse() {
                return super.sendResponse();
            }
        };
        assertEquals("MethodNotAllowed", new String(controller.sendResponse().responseToBytes()));
    }
}