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
        headers.put("HeaderTitle", "HeaderContent");
        return headers;
    }

    @Override
    public String getRawBody() {
        return rawRequest.toString();
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
