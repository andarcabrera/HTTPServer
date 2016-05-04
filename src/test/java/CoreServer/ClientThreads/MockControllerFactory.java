package CoreServer.ClientThreads;

import CoreServer.Controllers.*;
import CoreServer.Request.Request;
import CoreServer.Response.Response;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockControllerFactory extends AbstractControllerFactory{

    @Override
    public Controller createController(String controllerName, Request request, Response response, String methodsAllowed) {
        return new MockController(request, response, "");
    }
}
