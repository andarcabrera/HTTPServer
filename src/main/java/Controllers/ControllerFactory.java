package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public class ControllerFactory extends AbstractControllerFactory {
    @Override
    public Controller createSimpleController(RequestBuilder request, ResponseBuilder response) {
        return new SimpleController(request, response);
    }
}
