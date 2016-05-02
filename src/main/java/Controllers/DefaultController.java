package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public class DefaultController extends Controller{

    public DefaultController(RequestBuilder request, ResponseBuilder response, String methodsAllowed){
        super(request, response, methodsAllowed);
    }

    public ResponseBuilder sendResponse(String action) {
        response.setStatusCode("MethodNotAllowed");
        return response;
    }
}


