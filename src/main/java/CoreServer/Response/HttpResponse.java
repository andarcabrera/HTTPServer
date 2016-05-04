package CoreServer.Response;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class HttpResponse implements Response {
    private String version = "HTTP/1.1";
    private String statusCode;
    private HashMap<String, String> headers = new HashMap<>();
    private  ByteArrayOutputStream body = new ByteArrayOutputStream();
    private ByteArrayOutputStream byteResponse = new ByteArrayOutputStream();

    public void setStatusCode(String status){
        this.statusCode = StatusCodes.statusCodes.get(status);
    }

    public void addHeader(String headerTitle, String headerDetail){
        headers.put(headerTitle, headerDetail);
    }

    public void setResponseBody(byte[] message){
        body.write(message, 0, message.length);
    }

    public byte[] responseToBytes(){
        byte[] headerBytes =  entireHeader().getBytes();
        byteResponse.write(headerBytes, 0, headerBytes.length);
        if (body != null){
            byteResponse.write(body.toByteArray(), 0, body.toByteArray().length);
        }
        return byteResponse.toByteArray();
    }

    private String entireHeader(){
        return (version + " " + statusCode + "\n" +
                                headersToString() +
                                "\n");
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
}
