package Request;

import org.junit.Test;
import static org.junit.Assert.*;


public class RequestTest {

    @Test
    public void testGetRawRequestLines() throws Exception {
        StringBuffer rawRequest = new StringBuffer("GET url version\nheader1\nheader2");
        Request request = new Request(rawRequest);
        request.setRequestDetails();
        assertEquals("GET url version", request.getInitialLine());
        assertEquals("header1", request.getHeaders().get(0));
        assertEquals("header2", request.getHeaders().get(1));
        assertEquals("GET", request.getMethod());
        assertEquals("url", request.getUrl());
        assertEquals("version", request.getVersion());
        }

    @Test
    public void testSeparateHeaderBody() throws Exception {
        StringBuffer rawRequest1 = new StringBuffer("GET initial line\nheader1\n \nbody");
        Request request1 = new Request(rawRequest1);
        StringBuffer rawRequest2 = new StringBuffer("GET initial line\nheader1\n      \nbody");
        Request request2 = new Request(rawRequest2);
        StringBuffer rawRequest3 = new StringBuffer("GET initial line\nheader1\n\nbody");
        Request request3 = new Request(rawRequest3);
        request1.setRequestDetails();
        request2.setRequestDetails();
        request3.setRequestDetails();
        assertEquals("GET initial line\nheader1", request1.getRawHeader());
        assertEquals("body", request1.getRawBody());
        assertEquals("body", request2.getRawBody());
        assertEquals("body", request3.getRawBody());
    }

}