package CobSpecApp.Controllers;

import CoreServer.Controllers.Controller;
import CoreServer.FileMgmt.FileAccess;
import CoreServer.Request.Request;
import CoreServer.Response.Response;

import java.util.HashMap;


public class FileController extends Controller {
    private FileAccess accessFile;
    private String sourceDirectory;

    public FileController(Request request, Response response, String methodsAllowed, FileAccess accessFile, String sourceDirectory){
        super(request, response, methodsAllowed);
        this.accessFile = accessFile;
        this.sourceDirectory = sourceDirectory;
    }

    public Response showFileContent() {
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
        return response;
    }



}

