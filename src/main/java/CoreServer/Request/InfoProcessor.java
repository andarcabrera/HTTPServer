package CoreServer.Request;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public interface InfoProcessor {
    void handleRequest(StringBuffer rawRequest);
    RequestBuilder getRequest();
}
