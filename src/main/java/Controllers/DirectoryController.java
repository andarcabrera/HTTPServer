package Controllers;

import FileMgmt.AccessDirectory;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;

import java.io.File;


public class DirectoryController extends Controller{
    private AccessDirectory accessDirectory = new AccessDirectory();
    private HtmlContent htmlContent = new HtmlContent();

    public DirectoryController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public ResponseBuilder get(RequestBuilder request) {
        response.setStatusCode("OK");
        File files[] = accessDirectory.getFiles(sourceDirectory);
        byte[] body = htmlContent.htmlBody(files, sourceDirectory);
        response.setResponseBody(body);
        return response;
    }
}

