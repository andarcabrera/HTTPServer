package TTTApp.Controllers;

import CobSpecApp.Controllers.CobSpecControllerFactory;
import CoreServer.Controllers.Controller;
import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import CoreServer.FileMgmt.FileAccess;
import CoreServer.FileMgmt.MockAccessFile;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by andacabrera29 on 5/4/16.
 */
public class TTTControllerFactoryTest {
    private TTTControllerFactory controllerFactory;
    private Controller controller;
    private Request request;
    private Response response;
    private FileAccess accessFile;
    private StringBuffer requestDetails;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        accessFile = new MockAccessFile();
        requestDetails = new StringBuffer();
        controllerFactory = new TTTControllerFactory();
    }

    @Test
    public void testCreateSimpleController() throws Exception {
        controller = controllerFactory.createController("TTTController", request, response, "");
        assertEquals("TTTApp.Controllers.TTTController", controller.getClass().getName());
    }

    @Test
    public void testCreateDirectoryController() throws Exception {
        controller = controllerFactory.createController("", request, response, "");
        assertEquals("CoreServer.Controllers.DefaultController", controller.getClass().getName());
    }

}