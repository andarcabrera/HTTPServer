package Response;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResponseBuilderTest {

    @Test
    public void testResponseToBytes() throws Exception {
        ResponseBuilder response = new ResponseBuilder();
        response.setStatusCode(200);
        response.addHeader("Content-Type: text/html");
        response.setResponseBody("This is a test".getBytes());
        assertEquals("HTTP/1.0 200 OK\nContent-Type: text/html\n\nThis is a test", new String(response.responseToBytes()));
    }
}