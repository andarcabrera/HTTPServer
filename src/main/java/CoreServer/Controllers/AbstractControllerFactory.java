package CoreServer.Controllers;

import CoreServer.Request.RequestBuilder;
import CoreServer.Response.Response;

public abstract class AbstractControllerFactory {
    public abstract Controller createController(String controllerName, RequestBuilder request, Response response, String methodsAllowed);
}
