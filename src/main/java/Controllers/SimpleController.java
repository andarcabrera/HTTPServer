package Controllers;

import FileMgmt.AccessDirectory;
import FileMgmt.AccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;

import java.io.File;


public class SimpleController implements Controller{
    ResponseBuilder response;
    RequestBuilder request;
    private AccessFile accessFile = new AccessFile();
    private AccessDirectory accessDirectory = new AccessDirectory();
    private HtmlContent htmlContent = new HtmlContent();
    private String sourceDirectory = "/Users/andacabrera29/Desktop/cob_spec/public";

    public SimpleController(RequestBuilder request, ResponseBuilder response){
        this.request = request;
        this.response = response;
    }


    public byte[] sendResponse(){
        byte[] messageFromServer = null;
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
    public byte[] get(String action) {
        if (action.equals("/")){
            response.setStatusCode(200);
            File files[] = accessDirectory.getFiles("/Users/andacabrera29/Desktop/cob_spec/public");
            byte[] body = htmlContent.htmlBody(files, sourceDirectory);
            response.setResponseBody(body);
        } else {
            byte[] fileContent = accessFile.readFromFile(sourceDirectory + action);
            if (fileContent.length == 0){
                response.setStatusCode(404);
            } else {
                response.setStatusCode(200);
                response.setResponseBody(fileContent);
            }
        }
        return response.responseToBytes();
    }

    @Override
    public byte[] post(String action, String instructions) {
        response.setStatusCode(200);
        return response.responseToBytes();
    }

    @Override
    public byte[] put(String action, String instructions) {
        response.setStatusCode(200);
        return response.responseToBytes();    }

}
