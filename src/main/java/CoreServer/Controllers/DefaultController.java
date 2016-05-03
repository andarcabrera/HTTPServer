package CoreServer.Controllers;

import CoreServer.Request.RequestBuilder;
import CoreServer.Response.Response;


public class DefaultController extends Controller{

    public DefaultController(RequestBuilder request, Response response, String methodsAllowed){
        super(request, response, methodsAllowed);
    }

    public Response sendResponse(String action) {
        response.setStatusCode("MethodNotAllowed");
        return response;
    }
}


