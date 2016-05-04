package CoreServer.ClientThreads;

import CoreServer.Controllers.Controller;
import CoreServer.Request.Request;
import CoreServer.Response.Response;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockController extends Controller {
    public MockController(Request request, Response response, String methodsAllowed) {
        super(request, response, methodsAllowed);
    }

    public Response methodNotAllowed() {
        response.setStatusCode("MethodNotAllowed");
        return response;
    }

    public Response pageNotFound() {
        response.setStatusCode("PageNotFound");
        return response;
    }
}
