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

    public byte[] sendResponse(){
        byte[] messageFromServer = null;
        switch (request.getMethod()) {
            case "GET":
                messageFromServer = get(request);
                break;
            case "POST":
                messageFromServer = post(request);
                break;
            case "PUT":
                messageFromServer = put(request);
                break;
            case "DELETE":
                messageFromServer = delete(request);
                break;
            case "OPTIONS":
                messageFromServer = options();
                break;
            default:
                messageFromServer = bogus();
                break;
        }
        return messageFromServer;
    }

    public byte[] get(RequestBuilder request) {
        return fourOhFourResponse();
    }

    public byte[] post(RequestBuilder request) {
        return fourOhFourResponse();
    }

    public byte[] put(RequestBuilder request) {
        return fourOhFourResponse();
    }

    public byte[] delete(RequestBuilder request) {
        return fourOhFourResponse();
    }

    public byte[] options() {
        return fourOhFourResponse();
    }

    public byte[] bogus() {
        response.setStatusCode("MethodNotAllowed");
        return  response.responseToBytes();
    }

    private byte[] fourOhFourResponse() {
        response.setStatusCode("PageNotFound");
        return  response.responseToBytes();
    }


}
