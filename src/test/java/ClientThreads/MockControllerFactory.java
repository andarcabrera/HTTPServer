package ClientThreads;

import Controllers.*;
import Request.RequestBuilder;
import Response.ResponseBuilder;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockControllerFactory extends AbstractControllerFactory{

    @Override
    public Controller createSimpleController(RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }

    @Override
    public Controller createDirectoryController(RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }

    @Override
    public Controller createFileController(RequestBuilder request, ResponseBuilder response) {
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
    public Controller createPatchController(RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }

    @Override
    public Controller createBasicAuthController(RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }
}
