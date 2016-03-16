package Controllers;

import Helpers.Base64ParserAndDecoder;
import Helpers.RequestLogger;
import Request.RequestBuilder;
import Response.ResponseBuilder;

public class BasicAuthController extends Controller{
    Base64ParserAndDecoder decoder = new Base64ParserAndDecoder();
    private String user = "admin";
    private String password = "hunter2";

    public BasicAuthController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public ResponseBuilder get(RequestBuilder request) {
        String authorization = request.getHeaders().get("Authorization");
        if (authorization !=null) {
            decoder.decodeBase64(authorization);
            String currentUser =  decoder.getUser();
            String currentPassword =  decoder.getPassword();
            if (validCredentials(currentUser, currentPassword)){
                response.setStatusCode("OK");
                response.setResponseBody(RequestLogger.generateLogContent());
            } else{
                response.setStatusCode("Unauthorized");
                response.addHeader("WWW-Authenticate", "Basic realm=\"CobSpec Realm\"");
            }
        } else {
            response.setStatusCode("Unauthorized");
            response.addHeader("WWW-Authenticate", "Basic realm=\"CobSpec Realm\"");
        }
        return response;
    }

    private boolean validCredentials(String user, String password){
        return (this.user.equals(user) && this.password.equals(password));
    }

}