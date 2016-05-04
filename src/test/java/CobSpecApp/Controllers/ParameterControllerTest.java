package CobSpecApp.Controllers;

import CobSpecApp.Controllers.ParameterController;
import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class ParameterControllerTest {
    private ParameterController parameterController;
    private Request request;
    private Response response;
    private StringBuffer rawRequest = new StringBuffer();

    @Before
    public void setUp(){
        request = new MockRequest();
        rawRequest.append("method~GET  url~/action");
        request.buildRequest(rawRequest);
        response = new MockResponse();
        parameterController = new ParameterController(request, response, "");
    }


    @Test
    public void testGet() throws Exception {
        assertTrue(new String(parameterController.sendResponse("showParamsInBody").responseToBytes()).startsWith("OK"));
        assertTrue(new String(parameterController.sendResponse("showParamsInBody").responseToBytes()).contains("param"));
        assertTrue(new String(parameterController.sendResponse("showParamsInBody").responseToBytes()).contains("pam-pam"));
    }
}