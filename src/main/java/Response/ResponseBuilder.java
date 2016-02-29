package Response;

import Views.StatusCodes;

import java.util.ArrayList;
import java.util.Iterator;


public class ResponseBuilder {
    private String version = "HTTP/1.0";
    private String statusCode = "";
    private ArrayList<String> headers = new ArrayList<String>();
    private String body = "";

    public void setStatusCode(Integer code){
        this.statusCode = StatusCodes.getStatus(code);
    }

    public void addHeader(String header){
        headers.add(header);
    }

    public String toString(){
        return version + " " + statusCode + "\n" +
                headersToString() +
                "\n" +
                body;
        }

    private String headersToString(){
        String headersString = "";
        Iterator headersIterator = headers.iterator();
        while (headersIterator.hasNext()) {
            headersString += headersIterator.next() + "\n";
        }
        return headersString;
        }

    public void setResponseBody(String message){
        this.body = message;
    }
}
