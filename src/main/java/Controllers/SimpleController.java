package Controllers;

import FileMgmt.FileAccess;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;


public class SimpleController extends Controller{
    private FileAccess accessFile;
    private HtmlContent html = new HtmlContent();

    public SimpleController(RequestBuilder request, ResponseBuilder response, String methodsAllowed, FileAccess accessFile){
        super(request, response, methodsAllowed);
        this.accessFile = accessFile;
    }

    public ResponseBuilder getForm() {
        byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
        response.setStatusCode("OK");
        response.setResponseBody(html.formHtml("data"));
        response.setResponseBody(fileContent);
        return response;
    }

    public ResponseBuilder postForm() {
        accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
        response.setStatusCode("OK");
        return response;
    }

    public ResponseBuilder putForm() {
        accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
        response.setStatusCode("OK");
        return response;
    }

    public ResponseBuilder deleteForm() {
        accessFile.deleteFileContent(sourceDirectory + request.getUrl());
        response.setStatusCode("OK");
        return response;
    }

    public ResponseBuilder notFound() {
        response.setStatusCode("PageNotFound");
        return response;
    }

    public ResponseBuilder options() {
        response.setStatusCode("OK");
        response.addHeader("Allow", methodsAllowed);
        return response;
    }

}

