package Controllers;

import FileMgmt.AccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;


public class SimpleController extends Controller{
    private AccessFile accessFile = new AccessFile();
    private String sourceDirectory = "/Users/andacabrera29/Desktop/cob_spec/public";

    public SimpleController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public byte[] get(RequestBuilder request) {
        byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
        response.setStatusCode(200);
        response.setResponseBody(fileContent);
        return response.responseToBytes();
    }

    public byte[] post(RequestBuilder request) {
        accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
        response.setStatusCode(200);
        return response.responseToBytes();
    }

    public byte[] put(RequestBuilder request) {
        accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
        response.setStatusCode(200);
        return response.responseToBytes();
    }

    public byte[] delete(RequestBuilder request) {
        accessFile.deleteFileContent(sourceDirectory + request.getUrl());
        response.setStatusCode(200);
        return response.responseToBytes();
    }
}

