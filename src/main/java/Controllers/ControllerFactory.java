package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public class ControllerFactory extends AbstractControllerFactory {
    @Override
    public Controller createSimpleController(RequestBuilder request, ResponseBuilder response) {
        return new SimpleController(request, response);
    }

    @Override
    public Controller createDirectoryController(RequestBuilder request, ResponseBuilder response) {
        return new DirectoryController(request, response);
    }

    @Override
    public Controller createFileController(RequestBuilder request, ResponseBuilder response) {
        return new FileController(request, response);
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
}
