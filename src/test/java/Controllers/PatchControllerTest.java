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
public class PatchControllerTest {
    private PatchController patchController;
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
    public void testGet() throws Exception {
        requestDetails.append("method~GET  url~/");
        request.buildRequest(requestDetails);
        patchController = new PatchController(request, response, accessFile);

        assertEquals("OKETag: dc50a0d27dda2eee9f65644cd7e4c9cf11de8bec\nRead from file", new String(patchController.sendResponse().responseToBytes()));
    }

    @Test
    public void testPatchWithWrongPath() throws Exception {
        requestDetails.append("method~PATCH  url~/  If-Match~0");
        request.buildRequest(requestDetails);
        patchController = new PatchController(request, response, accessFile);

        assertEquals("OKRead from file", new String(patchController.sendResponse().responseToBytes()));

    }

    @Test
    public void testPatchWithCorrectPath() throws Exception {
        requestDetails.append("method~PATCH  url~/  If-Match~dc50a0d27dda2eee9f65644cd7e4c9cf11de8bec");
        request.buildRequest(requestDetails);
        patchController = new PatchController(request, response, accessFile);

        assertEquals("NoContent", new String(patchController.sendResponse().responseToBytes()));

    }
}