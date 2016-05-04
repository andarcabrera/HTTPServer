package CoreServer.Controllers;

import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

public class ControllerTest {
    private Controller controller;
    private Request request;
    private Response response;
    private String methodsAllowed;
    private StringBuffer requestDetails;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        requestDetails = new StringBuffer();
        methodsAllowed = "";

        controller = new Controller(request, response, methodsAllowed){};
    }

    @Test(expected = NoSuchMethodException.class)
    public void testSendResponseNoMethodException() throws Exception {
        requestDetails.append("method~GET");
        request.buildRequest(requestDetails);
        controller.sendResponse("noMethod");
    }
}