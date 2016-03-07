package Router;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/7/16.
 */
public class RoutesSetupTest {
    RoutesSetup setup;

    @Before
    public void setUp(){
        setup = new RoutesSetup();
    }


    @Test
    public void testGetRoutes() throws Exception {
        assertTrue(setup.getRoutes().containsKey("/"));
        assertTrue(setup.getRoutes().containsValue("simpleController"));
    }
}