package CoreServer.Router;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andacabrera29 on 5/2/16.
 */


public class HttpRouteTest {
    private HttpRoute httpRoute;

    @Test
    public void testSetRequestDetailsHeaderOnly() throws Exception {
        httpRoute = new HttpRoute("GET action", "controller", "controllerAction");
        assertEquals("GET action", httpRoute.getRequestAction());
        assertEquals("controller", httpRoute.getControllerName());
        assertEquals("controllerAction", httpRoute.getControllerAction());
        assertEquals("GET", httpRoute.getRouteMethod());
        assertEquals("action", httpRoute.getRouteURL());
    }
}