package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public class SimpleController extends Controller{

    public SimpleController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public byte[] post(RequestBuilder request) {
        response.setStatusCode(200);
        return response.responseToBytes();
    }

    public byte[] put(RequestBuilder request) {
        response.setStatusCode(200);
        return response.responseToBytes();
    }
}

