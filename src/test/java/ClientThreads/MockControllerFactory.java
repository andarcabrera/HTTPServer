package ClientThreads;

import Controllers.*;
import FileMgmt.FileAccess;
import Helpers.Base64ParserAndDecoder;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.AbstractViewFactory;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockControllerFactory extends AbstractControllerFactory{

    @Override
    public Controller createSimpleController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile) {
        return new MockController(request, response);
    }

    @Override
    public Controller createDirectoryController(RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }

    @Override
    public Controller createFileController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile) {
        return new MockController(request, response);
    }

    @Override
    public Controller createParameterController(RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }

    @Override
    public Controller createDefaultController(RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }

    @Override
    public Controller createRedirectController(RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }

    @Override
    public Controller createPatchController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile) {
        return new MockController(request, response);
    }

    @Override
    public Controller createBasicAuthController(RequestBuilder request, ResponseBuilder response, Base64ParserAndDecoder decoder) {
        return new MockController(request, response);
    }

    @Override
    public Controller createTTTController(RequestBuilder request, ResponseBuilder response, AbstractViewFactory factory) {
        return new MockController(request, response);
    }
}
