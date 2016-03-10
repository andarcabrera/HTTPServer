package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public class RedirectController extends Controller{

    public RedirectController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public ResponseBuilder get(RequestBuilder request) {
        response.setStatusCode("Redirect");
        response.addHeader("Location", "http://localhost:5000/");
        return response;
    }
}
