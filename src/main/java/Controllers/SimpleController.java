package Controllers;

import FileMgmt.FileAccess;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;


public class SimpleController extends Controller{
    private FileAccess accessFile;
    private HtmlContent html = new HtmlContent();

    public SimpleController(RequestBuilder request, ResponseBuilder response, FileAccess accessFile){
        super(request, response);
        this.accessFile = accessFile;
    }

    public ResponseBuilder get(RequestBuilder request) {
        byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
        response.setStatusCode("OK");
        response.setResponseBody(html.formHtml("data"));
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

