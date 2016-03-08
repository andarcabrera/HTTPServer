package Views;

import org.junit.Test;
import static org.junit.Assert.*;



/**
 * Created by andacabrera29 on 2/29/16.
 */
public class StatusCodesTest {

    @Test
    public void testgetStatus() throws Exception {
        assertEquals("200 OK", StatusCodes.getStatus("OK"));
        assertEquals("404 Not Found", StatusCodes.getStatus("PageNotFound"));
    }

}