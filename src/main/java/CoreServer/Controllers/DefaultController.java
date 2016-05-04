package CoreServer.Controllers;

import CoreServer.Request.Request;
import CoreServer.Response.Response;


public class DefaultController extends Controller{

    public DefaultController(Request request, Response response, String methodsAllowed){
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


