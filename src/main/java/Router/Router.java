package Router;

import Controllers.SimpleController;
import Request.Request;
import Response.ResponseBuilder;


/**
 * Created by andacabrera29 on 2/25/16.
 */
public class Router {
    ResponseBuilder response = new Response.ResponseBuilder();
    SimpleController controller;

    public void route(Request request) {
        controller = new SimpleController(request, response);

    }

    public byte[] getResponse(){
        return controller.sendResponse();
    }
}
