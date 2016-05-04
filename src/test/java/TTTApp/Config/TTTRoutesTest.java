package TTTApp.Config;

import org.junit.Test;
import static org.junit.Assert.*;


/**
 * Created by andacabrera29 on 5/4/16.
 */
public class TTTRoutesTest {
    private TTTRoutes tttRoutes;

    @Test
    public void testGetRoutes() throws Exception {
        tttRoutes = new TTTRoutes();
        assertEquals("GET /ttt", tttRoutes.getRoutes().get(0).getRequestAction());
        assertEquals("POST /games", tttRoutes.getRoutes().get(1).getRequestAction());
        assertEquals("PUT /make_move/", tttRoutes.getRoutes().get(2).getRequestAction());
    }
}