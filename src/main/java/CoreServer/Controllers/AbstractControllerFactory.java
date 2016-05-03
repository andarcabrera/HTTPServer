package CoreServer.Controllers;

import CoreServer.Request.Request;
import CoreServer.Response.Response;

public abstract class AbstractControllerFactory {
    public abstract Controller createController(String controllerName, Request request, Response response, String methodsAllowed);
}
