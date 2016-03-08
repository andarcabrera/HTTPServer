package Response;

import Views.StatusCodes;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class HttpServerResponse implements ResponseBuilder{
    private String version = "HTTP/1.0";
    private String statusCode = "";
    private HashMap<String, String> headers = new HashMap<>();
    private byte[] body;
    private ByteArrayOutputStream byteResponse = new ByteArrayOutputStream();

    public void setStatusCode(Integer code){
        this.statusCode = StatusCodes.getStatus(code);
    }

    public void addHeader(String headerTitle, String headerDetail){
        headers.put(headerTitle, headerDetail);
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
        for (Map.Entry<String, String> entry : headers.entrySet()) {
            String headerTitle = entry.getKey();
            String headerContent = entry.getValue();
            headersString += headerTitle + ": " + headerContent + "\n";
        }
        return headersString;
    }

    public void setResponseBody(byte[] message){
        this.body = message;
    }
}
