package CoreServer.Router;

import CoreServer.ClientThreads.MockControllerFactory;
import CoreServer.Controllers.AbstractControllerFactory;
import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class HttpRouterTest {
    private HttpRouter router;
    private Request request;
    private StringBuffer requestDetails;
    private AbstractControllerFactory controllerFactory;
    private Response response;
    private RoutesConfig routesSetup;

    @Before
    public void setUp(){
        controllerFactory = new MockControllerFactory();
        response = new MockResponse();
        routesSetup = new MockRoutesConfigSetup();
        request = new MockRequest();
        requestDetails = new StringBuffer();
        router = new HttpRouter(controllerFactory, response, routesSetup);
    }

    @Test
    public void testGetResponsePageNotFound() throws Exception {
        requestDetails.append("method~GET  url~URL");
        request.buildRequest(requestDetails);
        router.route(request);

        assertEquals("PageNotFound", new String(router.getResponse()));
    }

    @Test
    public void testGetResponseMethodNotAllowed() throws Exception {
        requestDetails.append("method~GET  url~routeURL");
        request.buildRequest(requestDetails);
        router.route(request);

        assertEquals("MethodNotAllowed", new String(router.getResponse()));
    }
}