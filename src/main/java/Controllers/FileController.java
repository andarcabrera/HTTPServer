package Controllers;

import FileMgmt.FileAccess;
import Request.RequestBuilder;
import Response.ResponseBuilder;

import java.util.HashMap;


public class FileController extends Controller{
    private FileAccess accessFile;

    public FileController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile){
        super(request, response);
        this.accessFile = accessFile;
    }

    public ResponseBuilder get(RequestBuilder request) {
        HashMap<String, String> headers = request.getHeaders();
        String range = headers.get("Range");

        byte[] fileContent;
        if (range != null){
            response.setStatusCode("PartialContent");
            fileContent = accessFile.readPartiallyFromFile(sourceDirectory + request.getUrl(), range);
        } else {
            response.setStatusCode("OK");
            fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
        }
        response.setResponseBody(fileContent);
        return response;
    }

    public ResponseBuilder post(RequestBuilder request) {
        response.setStatusCode("MethodNotAllowed");
        return response;
    }

    public ResponseBuilder put(RequestBuilder request) {
        response.setStatusCode("MethodNotAllowed");
        return response;
    }

}

