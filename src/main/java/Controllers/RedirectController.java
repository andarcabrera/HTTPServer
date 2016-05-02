package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public class RedirectController extends Controller{

    public RedirectController(RequestBuilder request, ResponseBuilder response, String methodsAllowed){
        super(request, response, methodsAllowed);
    }

    public ResponseBuilder redirect() {
        response.setStatusCode("Redirect");
        response.addHeader("Location", "http://localhost:5000/");
        return response;
    }
}
