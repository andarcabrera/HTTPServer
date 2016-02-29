package Response;

import org.junit.Test;
import static org.junit.Assert.*;

public class ResponseBuilderTest {

    @Test
    public void testToString() throws Exception {
        ResponseBuilder response = new ResponseBuilder();
        response.setStatusCode(200);
        response.addHeader("Content-Type: text/html");
        response.setResponseBody("This is a test");
        assertEquals("HTTP/1.0 200 OK\nContent-Type: text/html\n\nThis is a test", response.toString());

    }
}