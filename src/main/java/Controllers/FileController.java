package Controllers;

import FileMgmt.AccessDirectory;
import FileMgmt.AccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;


public class FileController extends Controller{
    private AccessFile accessFile = new AccessFile();
    private AccessDirectory accessDirectory = new AccessDirectory();
    private HtmlContent htmlContent = new HtmlContent();
    private String sourceDirectory = "/Users/andacabrera29/Desktop/cob_spec/public";

    public FileController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }


    public byte[] get(RequestBuilder request) {
        byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
        if (fileContent.length == 0){
            response.setStatusCode(404);
        } else {
            response.setStatusCode(200);
            response.setResponseBody(fileContent);
        }
        return response.responseToBytes();
    }

    public byte[] post(RequestBuilder request) {
        response.setStatusCode(405);
        return response.responseToBytes();
    }

    public byte[] put(RequestBuilder request) {
        response.setStatusCode(405);
        return response.responseToBytes();
    }
}

