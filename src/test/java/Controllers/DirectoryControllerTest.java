package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.Properties;

import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/10/16.
 */
public class DirectoryControllerTest {
    private DirectoryController directoryController;
    private RequestBuilder request;
    private ResponseBuilder response;
    private StringBuffer requestDetails;

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Before
    public void setUp(){
        request = new MockRequest();
        requestDetails = new StringBuffer();
        requestDetails.append("method~GET  url~/");

        request.buildRequest(requestDetails);
        response = new MockResponse();
    }


    @Test
    public void testGet() throws Exception {
        File createdFile= folder.newFile("bravo");
        File createdFile1= folder.newFile("bingo");
        File createdFile2= folder.newFile("bogus");
        File folderRoot = folder.getRoot();
        String folderPath = folderRoot.getPath();
        Properties props = System.getProperties();
        props.setProperty("source_directory", folderPath);
        directoryController = new DirectoryController(request, response);

        assertTrue(new String(directoryController.sendResponse().responseToBytes()).startsWith("OK"));
        assertTrue(new String(directoryController.sendResponse().responseToBytes()).contains("bravo"));
        assertTrue(new String(directoryController.sendResponse().responseToBytes()).contains("bingo"));
        assertTrue(new String(directoryController.sendResponse().responseToBytes()).contains("bogus"));
    }
}