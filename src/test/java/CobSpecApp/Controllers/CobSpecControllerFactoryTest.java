package CobSpecApp.Controllers;

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

import static org.junit.Assert.assertEquals;


/**
 * Created by andacabrera29 on 3/17/16.
 */
public class CobSpecControllerFactoryTest {
    private CobSpecControllerFactory controllerFactory;
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
        controllerFactory = new CobSpecControllerFactory("");
    }

    @Test
    public void testCreateSimpleController() throws Exception {
        controller = controllerFactory.createController("simpleController", request, response, "");
        assertEquals("CobSpecApp.Controllers.SimpleController", controller.getClass().getName());
    }

    @Test
    public void testCreateDirectoryController() throws Exception {
        controller = controllerFactory.createController("directoryController", request, response, "");
        assertEquals("CobSpecApp.Controllers.DirectoryController", controller.getClass().getName());
    }

    @Test
    public void testCreateFileController() throws Exception {
        controller = controllerFactory.createController("fileController", request, response, "");
        assertEquals("CobSpecApp.Controllers.FileController", controller.getClass().getName());

    }

    @Test
    public void testCreateParameterController() throws Exception {
        controller = controllerFactory.createController("parameterController", request, response, "");
        assertEquals("CobSpecApp.Controllers.ParameterController", controller.getClass().getName());
    }

    @Test
    public void testCreateDefaultController() throws Exception {
        controller = controllerFactory.createController("defaultController", request, response, "");
        assertEquals("CoreServer.Controllers.DefaultController", controller.getClass().getName());
    }

    @Test
    public void testCreateRedirectController() throws Exception {
        controller = controllerFactory.createController("redirectController", request, response, "");
        assertEquals("CobSpecApp.Controllers.RedirectController", controller.getClass().getName());
    }

    @Test
    public void testCreatePatchController() throws Exception {
        controller = controllerFactory.createController("patchController", request, response, "");
        assertEquals("CobSpecApp.Controllers.PatchController", controller.getClass().getName());
    }

    @Test
    public void testCreateBasicAuthController() throws Exception {
        controller = controllerFactory.createController("basicAuthController", request, response, "");
        assertEquals("CobSpecApp.Controllers.BasicAuthController", controller.getClass().getName());
    }
}