package CobSpecApp.Controllers;

import CobSpecApp.Controllers.DirectoryController;
import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class DirectoryControllerTest {
    private DirectoryController directoryController;
    private Request request;
    private Response response;
    private StringBuffer requestDetails;
    private String sourceDirectory;

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Before
    public void setUp(){
        request = new MockRequest();
        requestDetails = new StringBuffer();
        requestDetails.append("method~GET  url~/");
        request.buildRequest(requestDetails);
        response = new MockResponse();
        sourceDirectory = System.getProperty("user.dir");
    }


//    @Test
//    public void testIndex() throws Exception {
//        File createdFile= folder.newFile("bravo");
//        File createdFile1= folder.newFile("bingo");
//        File createdFile2= folder.newFile("bogus");
//        sourceDirectory = System.getProperty("user.dir");
//        directoryController = new DirectoryController(request, response, "", sourceDirectory);
//
//        assertTrue(new String(directoryController.sendResponse("index").responseToBytes()).startsWith("OK"));
//        assertTrue(new String(directoryController.sendResponse("index").responseToBytes()).contains("bravo"));
//        assertTrue(new String(directoryController.sendResponse("index").responseToBytes()).contains("bingo"));
//        assertTrue(new String(directoryController.sendResponse("index").responseToBytes()).contains("bogus"));
//    }

    @Test
    public void testHeadOnly() throws Exception {
        File createdFile= folder.newFile("bravo");
        File createdFile1= folder.newFile("bingo");
        File createdFile2= folder.newFile("bogus");
        directoryController = new DirectoryController(request, response, "", sourceDirectory);

        assertTrue(new String(directoryController.sendResponse("headOnly").responseToBytes()).startsWith("OK"));
        assertFalse(new String(directoryController.sendResponse("headOnly").responseToBytes()).contains("bravo"));
    }
}