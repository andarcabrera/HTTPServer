package Controllers;

import FileMgmt.FileAccess;
import FileMgmt.MockAccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


/**
 * Created by andacabrera29 on 3/17/16.
 */
public class ControllerFactoryTest {
    private ControllerFactory controllerFactory;
    private Controller controller;
    private RequestBuilder request;
    private ResponseBuilder response;
    private FileAccess accessFile;
    private StringBuffer requestDetails;

    @Before
    public void setUp(){
        request = new MockRequest();
        response = new MockResponse();
        accessFile = new MockAccessFile();
        requestDetails = new StringBuffer();
        controllerFactory = new ControllerFactory();
    }

    @Test
    public void testCreateSimpleController() throws Exception {
        controller = controllerFactory.createController("simpleController", request, response);
        assertEquals("Controllers.SimpleController", controller.getClass().getName());
    }

    @Test
    public void testCreateDirectoryController() throws Exception {
        controller = controllerFactory.createController("directoryController", request, response);
        assertEquals("Controllers.DirectoryController", controller.getClass().getName());
    }

    @Test
    public void testCreateFileController() throws Exception {
        controller = controllerFactory.createController("fileController", request, response);
        assertEquals("Controllers.FileController", controller.getClass().getName());

    }

    @Test
    public void testCreateParameterController() throws Exception {
        controller = controllerFactory.createController("parameterController", request, response);
        assertEquals("Controllers.ParameterController", controller.getClass().getName());
    }

    @Test
    public void testCreateDefaultController() throws Exception {
        controller = controllerFactory.createController(null, request, response);
        assertEquals("Controllers.DefaultController", controller.getClass().getName());
    }

    @Test
    public void testCreateRedirectController() throws Exception {
        controller = controllerFactory.createController("redirectController", request, response);
        assertEquals("Controllers.RedirectController", controller.getClass().getName());
    }

    @Test
    public void testCreatePatchController() throws Exception {
        controller = controllerFactory.createController("patchController", request, response);
        assertEquals("Controllers.PatchController", controller.getClass().getName());
    }

    @Test
    public void testCreateBasicAuthController() throws Exception {
        controller = controllerFactory.createController("basicAuthController", request, response);
        assertEquals("Controllers.BasicAuthController", controller.getClass().getName());
    }
}