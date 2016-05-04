package CobSpecApp.Controllers;

import CoreServer.Controllers.Controller;
import CobSpecApp.Parsers.Base64ParserAndDecoder;
import CobSpecApp.Config.RequestLogger;
import CoreServer.Request.Request;
import CoreServer.Response.Response;

public class BasicAuthController extends Controller {
    private Base64ParserAndDecoder decoder;
    private String user = "admin";
    private String password = "hunter2";

    public BasicAuthController(Request request, Response response, String methodsAllowed, Base64ParserAndDecoder decoder){
        super(request, response, methodsAllowed);
        this.decoder = decoder;
    }

    public Response getSecureResponse() {
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
