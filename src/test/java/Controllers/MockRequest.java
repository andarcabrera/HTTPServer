package Controllers;

import Request.RequestBuilder;

import java.util.HashMap;
import java.util.Map;


public class MockRequest implements RequestBuilder {
    private String rawRequestInfo;
    private Map<String, String> requestInfo = new HashMap<>();
    private StringBuffer rawRequest = new StringBuffer();
    HashMap<String, String> params = new HashMap<>();

    @Override
    public void buildRequest(StringBuffer rawRequest) {
        this.rawRequest = rawRequest;
        rawRequestInfo = rawRequest.toString();
        parseMockRequest();
    }

    @Override
    public String getInitialLine() {
        return "This is the initial line";
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return (HashMap<String, String>) requestInfo;
    }

    @Override
    public String getRawBody() {
        return requestInfo.get("rawBody");
    }

    @Override
    public String getMethod() {
        return requestInfo.get("method");
    }

    @Override
    public String getUrl() {
        return requestInfo.get("url");
    }

    @Override
    public String getVersion() {
        return requestInfo.get("version");
    }

    @Override
    public HashMap<String, String> getParams() {
        params.put("param", "pam-pam");
        return params;
    }

    private void parseMockRequest(){
        String[] splitRequest = rawRequestInfo.split("  ");
        for (String requestPart : splitRequest){
            String[] details = requestPart.split("~");
            requestInfo.put(details[0], details[1]);
        }
    }
}
