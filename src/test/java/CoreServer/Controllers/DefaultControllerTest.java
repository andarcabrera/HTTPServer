package CoreServer.Controllers;

import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class DefaultControllerTest {
    private DefaultController defaultController;
    private Request request;
    private Response response;
    private StringBuffer requestDetails;
    private String methodsAllowed;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        methodsAllowed = "";
        requestDetails = new StringBuffer();
        defaultController = new DefaultController(request, response, methodsAllowed);
    }

    @Test
    public void testMethosNotAllowed() throws Exception {
        requestDetails.append("method~GET url~url");
        request.buildRequest(requestDetails);

        assertEquals("MethodNotAllowed", new String(defaultController.sendResponse("methodNotAllowed").responseToBytes()));
    }

    @Test
    public void testPageNotFound() throws Exception {
        requestDetails.append("method~GET url~url");
        request.buildRequest(requestDetails);

        assertEquals("PageNotFound", new String(defaultController.sendResponse("pageNotFound").responseToBytes()));
    }


}