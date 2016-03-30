package Controllers;

import Request.RequestBuilder;

import java.util.HashMap;


public class MockRequest implements RequestBuilder {
    private StringBuffer rawRequest = new StringBuffer();
    private HashMap<String, String> headers = new HashMap<>();
    HashMap<String, String> params = new HashMap<>();

    @Override
    public void buildRequest(StringBuffer rawRequest) {
        this.rawRequest = rawRequest;
    }

    @Override
    public String getInitialLine() {
        return "This is the initial line";
    }

    @Override
    public HashMap<String, String> getHeaders() {
        if (parsedRawRequest().length > 3) {
            if (parsedRawRequest()[3].trim().equals("Authorization")) {
                headers.put(parsedRawRequest()[3], "Basic " + parsedRawRequest()[4]);
            } else{
                headers.put(parsedRawRequest()[3], parsedRawRequest()[4]);
            }
        }
        return headers;
    }

    @Override
    public String getRawBody() {
        return parsedRawRequest()[2];
    }

    @Override
    public String getMethod() {
        return parsedRawRequest()[0];
    }

    @Override
    public String getUrl() {
        return parsedRawRequest()[1];
    }

    @Override
    public String getVersion() {
        return "RequestVersion";
    }

    @Override
    public HashMap<String, String> getParams() {
        params.put("param", "pam-pam");
        return params;
    }

    private String[] parsedRawRequest(){
        return rawRequest.toString().split(" ");
    }
}
