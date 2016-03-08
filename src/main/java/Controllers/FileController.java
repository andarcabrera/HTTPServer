package Controllers;

import FileMgmt.AccessDirectory;
import FileMgmt.AccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;

import java.util.HashMap;


public class FileController extends Controller{
    private AccessFile accessFile = new AccessFile();
    private AccessDirectory accessDirectory = new AccessDirectory();
    private HtmlContent htmlContent = new HtmlContent();
    private String sourceDirectory = "/Users/andacabrera29/Desktop/cob_spec/public";

    public FileController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public byte[] get(RequestBuilder request) {
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
        return response.responseToBytes();
    }

    public byte[] post(RequestBuilder request) {
        response.setStatusCode("MethodNotAllowed");
        return response.responseToBytes();
    }

    public byte[] put(RequestBuilder request) {
        response.setStatusCode("MethodNotAllowed");
        return response.responseToBytes();
    }

}
