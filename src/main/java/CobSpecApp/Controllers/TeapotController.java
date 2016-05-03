package CobSpecApp.Controllers;

import CoreServer.Controllers.Controller;
import CoreServer.Request.Request;
import CoreServer.Response.Response;

/**
 * Created by andacabrera29 on 4/29/16.
 */
public class TeapotController extends Controller {

    public TeapotController(Request request, Response response, String methodsAllowed){
        super(request, response, methodsAllowed);
    }

    public Response coffee() {
        response.setStatusCode("Teapot");
        response.setResponseBody("I'm a teapot".getBytes());
        return response;
    }

    public Response tea() {
        response.setStatusCode("OK");
        return response;
    }
}
