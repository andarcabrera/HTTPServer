package CobSpecApp.Controllers;

import CoreServer.Controllers.Controller;
import CoreServer.FileMgmt.FileAccess;
import CoreServer.Request.RequestBuilder;
import CoreServer.Response.Response;
import CobSpecApp.Views.HtmlContent;


public class SimpleController extends Controller {
    private FileAccess accessFile;
    private String sourceDirectory;
    private HtmlContent html = new HtmlContent();

    public SimpleController(RequestBuilder request, Response response, String methodsAllowed, FileAccess accessFile, String sourceDirectory){
        super(request, response, methodsAllowed);
        this.accessFile = accessFile;
        this.sourceDirectory = sourceDirectory;
    }

    public Response getForm() {
        byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
        response.setStatusCode("OK");
        response.setResponseBody(html.formHtml("data"));
        response.setResponseBody(fileContent);
        return response;
    }

    public Response postForm() {
        accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
        response.setStatusCode("OK");
        return response;
    }

    public Response putForm() {
        accessFile.writeToFile(sourceDirectory + request.getUrl(), request.getRawBody());
        response.setStatusCode("OK");
        return response;
    }

    public Response deleteForm() {
        accessFile.deleteFileContent(sourceDirectory + request.getUrl());
        response.setStatusCode("OK");
        return response;
    }

    public Response notFound() {
        response.setStatusCode("PageNotFound");
        return response;
    }

    public Response options() {
        response.setStatusCode("OK");
        response.addHeader("Allow", methodsAllowed);
        return response;
    }

}

