package Controllers;

import Response.ResponseBuilder;

import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Map;


public class MockResponse implements ResponseBuilder {
    private String statusCode = "";
    private byte[] bodyContent;
    private ByteArrayOutputStream byteResponse = new ByteArrayOutputStream();
    private HashMap<String, String> headers = new HashMap<>();


    @Override
    public void setStatusCode(String status) {
        this.statusCode = status;
    }

    @Override
    public void addHeader(String headerTitle, String headerContent) {
        headers.put(headerTitle, headerContent);
    }

    @Override
    public void setResponseBody(byte[] bodyContent) {
        this.bodyContent = bodyContent;
    }

    @Override
    public byte[] responseToBytes() {
        byte[] statusBytes =  statusCode.getBytes();
        byteResponse.write(statusBytes, 0, statusBytes.length);
        byteResponse.write(headersToString().getBytes(), 0, headersToString().getBytes().length);
        if (bodyContent != null){
            byteResponse.write(bodyContent, 0, bodyContent.length);
        }
        return byteResponse.toByteArray();
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
