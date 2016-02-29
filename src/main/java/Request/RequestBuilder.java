package Request;

import java.util.ArrayList;


public interface RequestBuilder {
    String getInitialLine();

    public ArrayList<String> getHeaders();

    public String getRawBody();

    public String getMethod();

    public String getUrl();

    public String getVersion();

}
