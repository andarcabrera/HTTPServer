package Controllers;

import Request.RequestBuilder;
import Response.ResponseBuilder;


public abstract class Controller implements ControllerStrategy {
    private ResponseBuilder response;
    private RequestBuilder request;

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
        }
        return messageFromServer;
    }

    private byte[] get(RequestBuilder request) {
        return fourOhFourResponse();
    }

    private byte[] post(RequestBuilder request) {
        return fourOhFourResponse();
    }

    private byte[] put(RequestBuilder request) {
        return fourOhFourResponse();
    }

    private byte[] fourOhFourResponse() {
        response.setStatusCode(404);
        return  response.responseToBytes();
    }
}
