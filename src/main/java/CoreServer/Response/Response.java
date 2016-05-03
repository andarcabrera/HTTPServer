package CoreServer.Response;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public interface Response {
    void setStatusCode(String status);
    void addHeader(String headerTitle, String headerBody);
    void setResponseBody(byte[] bodyContent);
    byte[] responseToBytes();
}
