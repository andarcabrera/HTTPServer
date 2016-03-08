package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public abstract class Controller implements ControllerStrategy {
    protected ResponseBuilder response;
    protected RequestBuilder request;
    protected String sourceDirectory = System.getProperty("source_directory");

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

    protected ResponseBuilder get(RequestBuilder request) {
        return fourOhFourResponse();
    }

    protected ResponseBuilder post(RequestBuilder request) {
        return fourOhFourResponse();
    }

    protected ResponseBuilder put(RequestBuilder request) {
        return fourOhFourResponse();
    }

    protected ResponseBuilder delete(RequestBuilder request) {
        return fourOhFourResponse();
    }

    protected ResponseBuilder options() {
        return fourOhFourResponse();
    }

    protected ResponseBuilder bogus() {
        response.setStatusCode("MethodNotAllowed");
        return response;
    }

    private ResponseBuilder fourOhFourResponse() {
        response.setStatusCode("PageNotFound");
        return response;
    }


}
