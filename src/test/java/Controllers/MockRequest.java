package Controllers;

import Request.RequestBuilder;

import java.util.HashMap;


public class MockRequest implements RequestBuilder {
    private HashMap<String, String> mockRequestDetails;


    public MockRequest(HashMap<String, String> details){
        this.mockRequestDetails = details;
    }
    @Override
    public String getInitialLine() {
        return null;
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return null;
    }

    @Override
    public String getRawBody() {
        return null;
    }

    @Override
    public String getMethod() {
        return mockRequestDetails.get("method");
    }

    @Override
    public String getUrl() {
        return mockRequestDetails.get("url");
    }

    @Override
    public String getVersion() {
        return null;
    }

    @Override
    public HashMap<String, String> getParams() {
        HashMap<String, String> params = new HashMap<>();
        params.put("param", "pam-pam");
        return params;
    }
}
