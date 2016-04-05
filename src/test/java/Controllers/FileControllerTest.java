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
public class FileControllerTest {
    private FileController fileController;
    private RequestBuilder request;
    private ResponseBuilder response;
    private FileAccess accessFile;
    private StringBuffer requestDetails;

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Before
    public void setUp(){
        request = new MockRequest();
        requestDetails = new StringBuffer();
        response = new MockResponse();
        accessFile = new MockAccessFile();
    }

    @Test
    public void testGetFullFileContent() throws Exception {
        requestDetails.append("method~GET  url~/");
        request.buildRequest(requestDetails);
        fileController = new FileController(request, response, accessFile);

        assertEquals("OKRead from file", new String(fileController.sendResponse().responseToBytes()));
    }

    @Test
    public void testGetPartialFileContent() throws Exception {
        requestDetails.append("method~GET  url~/  Range~0");
        request.buildRequest(requestDetails);
        fileController = new FileController(request, response, accessFile);

        assertEquals("PartialContentPartially read from file", new String(fileController.sendResponse().responseToBytes()));
    }

    @Test
    public void testPost() throws Exception {
        requestDetails.append("method~POST  url~/");
        request.buildRequest(requestDetails);
        fileController = new FileController(request, response, accessFile);

        assertEquals("MethodNotAllowed", new String(fileController.sendResponse().responseToBytes()));
    }

    @Test
    public void testPut() throws Exception {
        requestDetails.append("method~PUT  url~/");
        request.buildRequest(requestDetails);
        fileController = new FileController(request, response, accessFile);

        assertEquals("MethodNotAllowed", new String(fileController.sendResponse().responseToBytes()));
    }
}