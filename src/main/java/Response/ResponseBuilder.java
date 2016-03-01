package Response;

import Views.StatusCodes;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;


public class ResponseBuilder {
    private String version = "HTTP/1.0";
    private String statusCode = "";
    private ArrayList<String> headers = new ArrayList<String>();
    private byte[] body;
    private ByteArrayOutputStream byteResponse = new ByteArrayOutputStream();

    public void setStatusCode(Integer code){
        this.statusCode = StatusCodes.getStatus(code);
    }

    public void addHeader(String header){
        headers.add(header);
    }

    public byte[] responseToBytes(){
        byte[] headerBytes =  entireHeader().getBytes();
        byteResponse.write(headerBytes, 0, headerBytes.length);
        if (body != null){
            byteResponse.write(body, 0, body.length);
        }
        return byteResponse.toByteArray();
    }

    private String entireHeader(){
        String buildHeader = (version + " " + statusCode + "\n" +
                                headersToString() +
                                "\n");
        return buildHeader;
    }

    private String headersToString(){
        String headersString = "";
        Iterator headersIterator = headers.iterator();
        while (headersIterator.hasNext()) {
            headersString += headersIterator.next() + "\n";
        }
        return headersString;
        }

    public void setResponseBody(byte[] message){
        this.body = message;
    }
}
