package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public class DefaultController extends Controller{

    public DefaultController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public ResponseBuilder get(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response;
    }

    public ResponseBuilder post(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response;
    }

    public ResponseBuilder put(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response;
    }
}


