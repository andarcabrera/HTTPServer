package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;

import java.util.HashMap;
import java.util.Map;


public class ParameterController extends Controller{
    public ParameterController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public ResponseBuilder get(RequestBuilder request) {
        response.setStatusCode("OK");
        response.setResponseBody(getParams(request.getParams()));
        return response;
    }

    private byte[] getParams(HashMap <String, String> params){
        String paramDetails = "";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String name = entry.getKey();
            String content = entry.getValue();
            String variable = name + " = " + content + "\n";
            paramDetails += variable;
        }
        return  paramDetails.getBytes();
    }
}

