package Request;

import java.util.HashMap;


public interface RequestBuilder {
    String getInitialLine();

    public HashMap<String, String> getHeaders();

    public String getRawBody();

    public String getMethod();

    public String getUrl();

    public String getVersion();

    public HashMap<String, String> getParams();

}
