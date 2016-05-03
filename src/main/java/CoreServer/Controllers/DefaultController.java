package CoreServer.Controllers;

import CoreServer.Request.Request;
import CoreServer.Response.Response;


public class DefaultController extends Controller{

    public DefaultController(Request request, Response response, String methodsAllowed){
        super(request, response, methodsAllowed);
    }

    public Response sendResponse(String action) {
        response.setStatusCode("MethodNotAllowed");
        return response;
    }
}


