package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;

public abstract class AbstractControllerFactory {
    public abstract Controller createController(String controllerName, RequestBuilder request, ResponseBuilder response);
}
