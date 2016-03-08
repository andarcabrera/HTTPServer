package Controllers;

import FileMgmt.AccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;


public class SimpleController extends Controller{
    private AccessFile accessFile = new AccessFile();

    public SimpleController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public ResponseBuilder get(RequestBuilder request) {
        byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
        response.setStatusCode("OK");
        response.setResponseBody(fileContent);
        return response;
    }

    public ResponseBuilder post(RequestBuilder request) {
        accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
        response.setStatusCode("OK");
        return response;
    }

    public ResponseBuilder put(RequestBuilder request) {
        accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
        response.setStatusCode("OK");
        return response;
    }

    public ResponseBuilder delete(RequestBuilder request) {
        accessFile.deleteFileContent(sourceDirectory + request.getUrl());
        response.setStatusCode("OK");
        return response;
    }

    public ResponseBuilder options() {
        response.setStatusCode("OK");
        response.addHeader("Allow", "GET,HEAD,POST,OPTIONS,PUT");
        return response;
    }
}

