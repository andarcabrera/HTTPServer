package Controllers;

import FileMgmt.FileAccess;
import Request.RequestBuilder;
import Response.ResponseBuilder;


public class PatchController extends Controller{
    private FileAccess accessFile;
    private String etag = "dc50a0d27dda2eee9f65644cd7e4c9cf11de8bec";

    public PatchController(RequestBuilder request, ResponseBuilder response, String methodsAllowed, FileAccess accessFile){
        super(request, response, methodsAllowed);
        this.accessFile = accessFile;
    }

    public ResponseBuilder show() {
        byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
        response.setStatusCode("OK");
        response.addHeader("ETag", etag);
        response.setResponseBody(fileContent);
        return response;
    }

    public ResponseBuilder showPatched() {
        String requestEtag = request.getHeaders().get("If-Match");
        byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());

        if (etag.trim().equals(requestEtag.trim())) {
            response.setStatusCode("NoContent");
            accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
            etag = "5c36acad75b78b82be6d9cbbd6143ab7e0cc04b0";
        } else{
            response.setStatusCode("OK");
            accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
            response.setResponseBody(fileContent);
            etag = "5c36acad75b78b82be6d9cbbd6143ab7e0cc04b0";
        }
        return response;
    }
}
