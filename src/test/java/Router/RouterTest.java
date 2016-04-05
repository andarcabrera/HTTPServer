package Router;

import ClientThreads.MockControllerFactory;
import Controllers.AbstractControllerFactory;
import Controllers.MockRequest;
import Controllers.MockResponse;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class RouterTest {
    private Router router;
    private RequestBuilder request;
    private StringBuffer requestDetails;
    private AbstractControllerFactory controllerFactory;
    private ResponseBuilder response;
    private TrackRoutes routesSetup;

    @Before
    public void setUp(){
        controllerFactory = new MockControllerFactory();
        response = new MockResponse();
        routesSetup = new MockRoutesSetup();
        request = new MockRequest();
        requestDetails = new StringBuffer();
        router = new Router(controllerFactory, response, routesSetup);
    }

    @Test
    public void testGetResponse() throws Exception {
        requestDetails.append("method~GET");
        request.buildRequest(requestDetails);
        router.route(request);

        assertEquals("PageNotFound", new String(router.getResponse()));
    }

}