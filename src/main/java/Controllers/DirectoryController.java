package Controllers;

import FileMgmt.AccessDirectory;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;

import java.io.File;


public class DirectoryController extends Controller{
    private AccessDirectory accessDirectory = new AccessDirectory();
    private HtmlContent htmlContent = new HtmlContent();
    private String sourceDirectory = "/Users/andacabrera29/Desktop/cob_spec/public";

    public DirectoryController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public byte[] get(RequestBuilder request) {
        response.setStatusCode("OK");
        File files[] = accessDirectory.getFiles("/Users/andacabrera29/Desktop/cob_spec/public");
        byte[] body = htmlContent.htmlBody(files, sourceDirectory);
        response.setResponseBody(body);
        return response.responseToBytes();
    }
}

