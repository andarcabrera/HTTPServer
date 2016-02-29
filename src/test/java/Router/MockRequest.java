package Router;

import Request.RequestBuilder;

import java.util.ArrayList;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class MockRequest implements RequestBuilder {
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
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public String getVersion() {
        return null;
    }
}
