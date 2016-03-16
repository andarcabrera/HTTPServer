package Controllers;

import FileMgmt.FileAccess;
import Request.RequestBuilder;
import Response.ResponseBuilder;


public class ControllerFactory extends AbstractControllerFactory {
    @Override
    public Controller createSimpleController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile) {
        return new SimpleController(request, response, accessFile);
    }

    @Override
    public Controller createDirectoryController(RequestBuilder request, ResponseBuilder response) {
        return new DirectoryController(request, response);
    }

    @Override
    public Controller createFileController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile) {
        return new FileController(request, response, accessFile);
    }

    @Override
    public Controller createParameterController(RequestBuilder request, ResponseBuilder response) {
        return new ParameterController(request, response);
    }

    @Override
    public Controller createDefaultController(RequestBuilder request, ResponseBuilder response) {
        return new DefaultController(request, response);
    }

    @Override
    public Controller createRedirectController(RequestBuilder request, ResponseBuilder response) {
        return new RedirectController(request, response);
    }

    @Override
    public Controller createPatchController(RequestBuilder request, ResponseBuilder response) {
        return new PatchController(request, response);
    }

    @Override
    public Controller createBasicAuthController(RequestBuilder request, ResponseBuilder response) {
        return new BasicAuthController(request, response);
    }
}
