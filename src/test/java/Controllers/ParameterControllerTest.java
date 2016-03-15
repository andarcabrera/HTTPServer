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
public class ParameterControllerTest {
    private ParameterController parameterController;
    private RequestBuilder request;
    private ResponseBuilder response;

    @Before
    public void setUp(){
        HashMap<String, String> requestDetails = new HashMap<>();
        requestDetails.put("method", "GET");
        request = new MockRequest(requestDetails);
        response = new MockResponse();
        parameterController = new ParameterController(request, response);
    }


    @Test
    public void testGet() throws Exception {
        assertTrue(new String(parameterController.sendResponse().responseToBytes()).startsWith("OK"));
        assertTrue(new String(parameterController.sendResponse().responseToBytes()).contains("param"));
        assertTrue(new String(parameterController.sendResponse().responseToBytes()).contains("pam-pam"));
    }
}