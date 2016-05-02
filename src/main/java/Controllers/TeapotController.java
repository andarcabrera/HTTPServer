package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;

/**
 * Created by andacabrera29 on 4/29/16.
 */
public class TeapotController extends Controller {

    public TeapotController(RequestBuilder request, ResponseBuilder response, String methodsAllowed){
        super(request, response, methodsAllowed);
    }

    public ResponseBuilder coffee() {
        response.setStatusCode("Teapot");
        response.setResponseBody("I'm a teapot".getBytes());
        return response;
    }

    public ResponseBuilder tea() {
        response.setStatusCode("OK");
        return response;
    }
}
