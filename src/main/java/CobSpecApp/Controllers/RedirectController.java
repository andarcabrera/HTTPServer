package CobSpecApp.Controllers;

import CoreServer.Controllers.Controller;
import CoreServer.Request.RequestBuilder;
import CoreServer.Response.Response;


public class RedirectController extends Controller {

    public RedirectController(RequestBuilder request, Response response, String methodsAllowed){
        super(request, response, methodsAllowed);
    }

    public Response redirect() {
        response.setStatusCode("Redirect");
        response.addHeader("Location", "http://localhost:5000/");
        return response;
    }
}
