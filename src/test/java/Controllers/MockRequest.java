package Controllers;

import Request.RequestBuilder;

import java.util.ArrayList;
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
    public ArrayList<String> getHeaders() {
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
        return null;
    }
}
