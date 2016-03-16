package Controllers;

import FileMgmt.FileAccess;
import FileMgmt.MockAccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/16/16.
 */
public class SimpleControllerTest {
    private SimpleController simpleController;
    private RequestBuilder request;
    private ResponseBuilder response;
    private FileAccess accessFile;
    private StringBuffer requestDetails;

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        accessFile = new MockAccessFile();
        requestDetails = new StringBuffer();
        simpleController = new SimpleController(request, response, accessFile);
    }

    @Test
    public void testGet() throws Exception {
        requestDetails.append("GET action");
        request.buildRequest(requestDetails);

        assertEquals("OKRead from file", new String(simpleController.sendResponse().responseToBytes()));
    }

    @Test
    public void testPost() throws Exception {
        requestDetails.append("POST action");
        request.buildRequest(requestDetails);

        assertEquals("OK", new String(simpleController.sendResponse().responseToBytes()));
    }

    @Test
    public void testPut() throws Exception {
        requestDetails.append("PUT action");
        request.buildRequest(requestDetails);

        assertEquals("OK", new String(simpleController.sendResponse().responseToBytes()));
    }

    @Test
    public void testDelete() throws Exception {
        requestDetails.append("DELETE action");
        request.buildRequest(requestDetails);

        assertEquals("OK", new String(simpleController.sendResponse().responseToBytes()));
    }

    @Test
    public void testOptions() throws Exception {
        requestDetails.append("OPTIONS action");
        request.buildRequest(requestDetails);

        assertEquals("OKAllow: GET,HEAD,POST,OPTIONS,PUT", new String(simpleController.sendResponse().responseToBytes()).trim());
    }
}