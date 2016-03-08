//package Controllers;
//
//import Request.RequestBuilder;
//import Response.ResponseBuilder;
//import org.junit.Test;
//
//import java.util.HashMap;
//
//import static org.junit.Assert.assertEquals;
//
//
//public class ControllerTest {
//    private Controller controller;
//
//
//    @Test
//    public void testSendResponseGet() throws Exception {
//        HashMap<String, String> requestDetails = new HashMap<>();
//        requestDetails.put("method", "GET");
//        RequestBuilder request = new MockRequest(requestDetails);
//        ResponseBuilder response = new MockResponse();
//        controller = new Controller(request, response) {
//            @Override
//            public byte[] sendResponse() {
//                return super.sendResponse();
//            }
//        };
//        assertEquals("404", new String(controller.sendResponse()));
//    }
//
//    @Test
//    public void testSendResponsePut() throws Exception {
//        HashMap<String, String> requestDetails = new HashMap<>();
//        requestDetails.put("method", "PUT");
//        RequestBuilder request = new MockRequest(requestDetails);
//        ResponseBuilder response = new MockResponse();
//        controller = new Controller(request, response) {
//            @Override
//            public byte[] sendResponse() {
//                return super.sendResponse();
//            }
//        };
//        assertEquals("404", new String(controller.sendResponse()));
//    }
//}