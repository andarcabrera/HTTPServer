package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public abstract class Controller implements ControllerStrategy {
    public ResponseBuilder response;
    public RequestBuilder request;

    public Controller(RequestBuilder request, ResponseBuilder response){
        this.request = request;
        this.response = response;
    }

    public ResponseBuilder sendResponse(){
        switch (request.getMethod()) {
            case "GET":
                response = get(request);
                break;
            case "POST":
                response = post(request);
                break;
            case "PUT":
                response = put(request);
                break;
            case "DELETE":
                response = delete(request);
                break;
            case "OPTIONS":
                response = options();
                break;
            default:
                response = bogus();
                break;
        }
        return response;
    }

    public ResponseBuilder get(RequestBuilder request) {
        return fourOhFourResponse();
    }

    public ResponseBuilder post(RequestBuilder request) {
        return fourOhFourResponse();
    }

    public ResponseBuilder put(RequestBuilder request) {
        return fourOhFourResponse();
    }

    public ResponseBuilder delete(RequestBuilder request) {
        return fourOhFourResponse();
    }

    public ResponseBuilder options() {
        return fourOhFourResponse();
    }

    public ResponseBuilder bogus() {
        response.setStatusCode("MethodNotAllowed");
        return response;
    }

    private ResponseBuilder fourOhFourResponse() {
        response.setStatusCode("PageNotFound");
        return response;
    }


}
