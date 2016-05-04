package CobSpecApp.Controllers;

import CobSpecApp.Controllers.SimpleController;
import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import CoreServer.FileMgmt.FileAccess;
import CoreServer.FileMgmt.MockAccessFile;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
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
    private Request request;
    private Response response;
    private FileAccess accessFile;
    private StringBuffer requestDetails;
    private String sourceDirectory;

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        accessFile = new MockAccessFile();
        requestDetails = new StringBuffer();
        sourceDirectory = System.getProperty("user.dir");
        simpleController = new SimpleController(request, response, "", accessFile, sourceDirectory);
    }

    @Test
    public void testGetForm() throws Exception {
        assertEquals("OKRead from file", new String(simpleController.sendResponse("getForm").responseToBytes()));
    }

    @Test
    public void testPostForm() throws Exception {
        assertEquals("OK", new String(simpleController.sendResponse("postForm").responseToBytes()));
    }

    @Test
    public void testPutForm() throws Exception {
        assertEquals("OK", new String(simpleController.sendResponse("putForm").responseToBytes()));
    }

    @Test
    public void testDelete() throws Exception {
        assertEquals("OK", new String(simpleController.sendResponse("deleteForm").responseToBytes()));
    }

    @Test
    public void testNotFound() throws Exception {
        assertEquals("PageNotFound", new String(simpleController.sendResponse("notFound").responseToBytes()).trim());
    }

    @Test
    public void testOptions() throws Exception {
        assertEquals("OKAllow:", new String(simpleController.sendResponse("options").responseToBytes()).trim());
    }
}