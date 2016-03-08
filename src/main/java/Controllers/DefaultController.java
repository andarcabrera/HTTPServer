package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public class DefaultController extends Controller{

    public DefaultController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public byte[] get(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response.responseToBytes();
    }

    public byte[] post(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response.responseToBytes();
    }

    public byte[] put(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response.responseToBytes();
    }
}

