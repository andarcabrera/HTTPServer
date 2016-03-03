package Controllers;

import FileMgmt.AccessDirectory;
import FileMgmt.AccessFile;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.HtmlContent;

import java.io.File;
import java.util.HashMap;
import java.util.Map;


public class SimpleController extends Controller{
    private AccessFile accessFile = new AccessFile();
    private AccessDirectory accessDirectory = new AccessDirectory();
    private HtmlContent htmlContent = new HtmlContent();
    private String sourceDirectory = "/Users/andacabrera29/Desktop/cob_spec/public";

    public SimpleController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }


    public byte[] get(RequestBuilder request) {
        if (request.getUrl().equals("/")){
            response.setStatusCode(200);
            File files[] = accessDirectory.getFiles("/Users/andacabrera29/Desktop/cob_spec/public");
            byte[] body = htmlContent.htmlBody(files, sourceDirectory);
            response.setResponseBody(body);
        } else if (request.getUrl().equals("/parameters")){
            response.setStatusCode(200);
            response.setResponseBody(getParams(request.getParams()));
        } else {
            byte[] fileContent = accessFile.readFromFile(sourceDirectory + request.getUrl());
            if (fileContent.length == 0){
                response.setStatusCode(404);
            } else {
                response.setStatusCode(200);
                response.setResponseBody(fileContent);
            }
        }
        return response.responseToBytes();
    }

    public byte[] post(RequestBuilder request) {
        response.setStatusCode(200);
        return response.responseToBytes();
    }

    public byte[] put(RequestBuilder request) {
        response.setStatusCode(200);
        return response.responseToBytes();
    }

    private byte[] getParams(HashMap <String, String> params){
        String paramDetails = "";
        for (Map.Entry<String, String> entry : params.entrySet()) {
            String name = entry.getKey();
            String content = entry.getValue();
            String variable = name + " = " + content + "\n";
            paramDetails += variable;
            }
        return  paramDetails.getBytes();
        }
    }

