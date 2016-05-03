package CobSpecApp.Controllers;

import CoreServer.Controllers.Controller;
import CoreServer.FileMgmt.AccessDirectory;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import CobSpecApp.Views.HtmlContent;

import java.io.File;


public class DirectoryController extends Controller {
    private AccessDirectory accessDirectory = new AccessDirectory();
    private String sourceDirectory;
    private HtmlContent htmlContent = new HtmlContent();

    public DirectoryController(Request request, Response response, String methodsAllowed, String sourceDirectory){
        super(request, response, methodsAllowed);
        this.sourceDirectory = sourceDirectory;
    }

    public Response index() {
        response.setStatusCode("OK");
        File files[] = accessDirectory.getFiles(sourceDirectory);
        byte[] body = htmlContent.htmlBody(files, sourceDirectory);
        response.setResponseBody(body);
        return response;
    }

    public Response headOnly() {
        response.setStatusCode("OK");
        return response;
    }
}

