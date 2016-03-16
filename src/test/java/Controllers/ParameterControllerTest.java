package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class ParameterControllerTest {
    private ParameterController parameterController;
    private RequestBuilder request;
    private ResponseBuilder response;
    private StringBuffer rawRequest = new StringBuffer();

    @Before
    public void setUp(){
        request = new MockRequest();
        rawRequest.append("GET /action");
        request.buildRequest(rawRequest);
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