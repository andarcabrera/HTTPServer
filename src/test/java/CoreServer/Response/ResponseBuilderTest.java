package CoreServer.Response;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResponseBuilderTest {

    @Test
    public void testResponseToBytes() throws Exception {
        HttpResponse response = new HttpResponse();
        response.setStatusCode("OK");
        response.addHeader("Content-Type", "text/html");
        response.setResponseBody("This is a test".getBytes());
        assertEquals("HTTP/1.1 200 OK\nContent-Type: text/html\n\nThis is a test", new String(response.responseToBytes()));
    }
}