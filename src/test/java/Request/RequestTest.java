package Request;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;


public class RequestTest {
    private Request request;

    @Before
    public void setUp(){
        request = new Request();
    }

    @Test
    public void testSetRequestDetailsHeaderOnly() throws Exception {
        StringBuffer rawRequest = new StringBuffer("GET url version\nheader_title: header_body\nheader2_title: header2_body\n \n");
        request.buildRequest(rawRequest);
        assertEquals("GET url version", request.getInitialLine());
        assertEquals("header_body", request.getHeaders().get("header_title"));
        assertEquals("header2_body", request.getHeaders().get("header2_title"));
        assertEquals("GET", request.getMethod());
        assertEquals("url", request.getUrl());
        assertEquals("version", request.getVersion());
        }

    @Test
    public void testSetRequestDetailsWithBody() throws Exception {
        StringBuffer rawRequest1 = new StringBuffer("GET initial line\nheader_title: header_body\n \nbody");
        request.buildRequest(rawRequest1);
        StringBuffer rawRequest2 = new StringBuffer("GET initial line\nheader_title: header_body\n      \nbody");
        request.buildRequest(rawRequest1);
        StringBuffer rawRequest3 = new StringBuffer("GET initial line\nheader_title: header_body\n\nbody");
        request.buildRequest(rawRequest1);
        assertEquals("GET initial line\nheader_title: header_body", request.getRawHeader());
        assertEquals("body", request.getRawBody());
        assertEquals("body", request.getRawBody());
        assertEquals("body", request.getRawBody());
    }

    @Test
    public void testSetRequestDetailsWithParams() throws Exception {
        StringBuffer rawRequest = new StringBuffer("GET /parameters?variable_1=Operators%20%3C%2C%20%3E%2C%20%3D%2C%20!%3D%3B%20%2B%2C%20-%2C%20*%2C%20%26%2C%20%40%2C%20%23%2C%20%24%2C%20%5B%2C%20%5D%3A%20%22is%20that%20all%22%3F&variable_2=stuff HTTP\n");
        request.buildRequest(rawRequest);
        assertEquals("GET", request.getMethod());
        assertEquals("/parameters", request.getUrl());
        assertEquals("Operators <, >, =, !=; +, -, *, &, @, #, $, [, ]: \"is that all\"?", request.getParams().get("variable_1"));
        assertEquals("stuff", request.getParams().get("variable_2"));
    }
}
