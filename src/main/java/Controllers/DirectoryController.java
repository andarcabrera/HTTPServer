package Controllers;

import FileMgmt.AccessDirectory;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;

import java.io.File;


public class DirectoryController extends Controller{
    private AccessDirectory accessDirectory = new AccessDirectory();
    private HtmlContent htmlContent = new HtmlContent();

    public DirectoryController(RequestBuilder request, ResponseBuilder response, String methodsAllowed){
        super(request, response, methodsAllowed);
    }

    public ResponseBuilder index() {
        response.setStatusCode("OK");
        File files[] = accessDirectory.getFiles(sourceDirectory);
        byte[] body = htmlContent.htmlBody(files, sourceDirectory);
        response.setResponseBody(body);
        return response;
    }

    public ResponseBuilder headOnly() {
        response.setStatusCode("OK");
        return response;
    }
}

