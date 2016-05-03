package CoreServer.Request;

import java.util.HashMap;


public interface RequestBuilder {

    void buildRequest(StringBuffer rawRequest);

    String getInitialLine();

    HashMap<String, String> getHeaders();

    String getRawBody();

    String getMethod();

    String getUrl();

    String getVersion();

    HashMap<String, String> getParams();

    String getRequestAction();

}
