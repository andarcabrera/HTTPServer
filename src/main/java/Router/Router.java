package Router;

import Controllers.SimpleController;
import Request.Request;
import Response.HttpServerResponse;


public class Router {
    HttpServerResponse response = new HttpServerResponse();
    SimpleController controller;

    public void route(Request request) {
        controller = new SimpleController(request, response);

    }

    public byte[] getResponse(){
        return controller.sendResponse();
    }
}
