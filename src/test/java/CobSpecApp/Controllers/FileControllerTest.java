package CobSpecApp.Controllers;

import CobSpecApp.Controllers.FileController;
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
public class FileControllerTest {
    private FileController fileController;
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
        requestDetails = new StringBuffer();
        response = new MockResponse();
        accessFile = new MockAccessFile();
        sourceDirectory = System.getProperty("user.dir");
    }

    @Test
    public void testShowFileContent() throws Exception {
        requestDetails.append("method~GET  url~/  Range~0");
        request.buildRequest(requestDetails);
        fileController = new FileController(request, response, "", accessFile, sourceDirectory);

        assertEquals("PartialContentPartially read from file", new String(fileController.sendResponse("showFileContent").responseToBytes()));
    }

}