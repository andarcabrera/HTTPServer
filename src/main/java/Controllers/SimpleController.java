package Controllers;

import FileMgmt.AccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;


public class SimpleController implements Controller{
    ResponseBuilder response;
    private AccessFile accessFile = new AccessFile();
    RequestBuilder request;

    public SimpleController(RequestBuilder request, ResponseBuilder response){
        this.request = request;
        this.response = response;
    }


    public String sendResponse(){
        String messageFromServer = null;
        switch (request.getMethod()) {
            case "GET":
               messageFromServer = get(request.getUrl());
                break;
            case "POST":
                messageFromServer = post(request.getUrl(), request.getRawBody());
                break;
            case "PUT":
                messageFromServer = put(request.getUrl(), request.getRawBody());
                break;
        }
        return messageFromServer;
    }

    @Override
    public String get(String action) {
        if (action.equals("/")){
            response.setStatusCode(200);
        } else {
            String fileContent = accessFile.readFromFile(action);
            if (fileContent.isEmpty()){
                response.setStatusCode(404);
            } else {
                response.setStatusCode(200);
                response.setResponseBody(fileContent);
            }
        }
        return response.toString();
    }

    @Override
    public String post(String action, String instructions) {
        response.setStatusCode(200);
        return response.toString();
    }

    @Override
    public String put(String action, String instructions) {
        response.setStatusCode(200);
        return response.toString();    }

    @Override
    public String delete(String action, String instructions) {
        response.setStatusCode(200);
        return response.toString();    }
}
