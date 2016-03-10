package Controllers;

import Response.ResponseBuilder;

import java.io.ByteArrayOutputStream;


public class MockResponse implements ResponseBuilder {
    private String statusCode = "";
    private byte[] bodyContent;
    private ByteArrayOutputStream byteResponse = new ByteArrayOutputStream();


    @Override
    public void setStatusCode(String status) {
        this.statusCode = status;
    }

    @Override
    public void addHeader(String headerTitle, String headerContent) {

    }

    @Override
    public void setResponseBody(byte[] bodyContent) {
        this.bodyContent = bodyContent;
    }

    @Override
    public byte[] responseToBytes() {
        byte[] statusBytes =  statusCode.getBytes();
        byteResponse.write(statusBytes, 0, statusBytes.length);
        if (bodyContent != null){
            byteResponse.write(bodyContent, 0, bodyContent.length);
        }
        return byteResponse.toByteArray();
    }
}
