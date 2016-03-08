package Response;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public interface ResponseBuilder {
    public void setStatusCode(String status);
    public void addHeader(String headerTitle, String headerBody);
    public void setResponseBody(byte[] bodyContent);
    public byte[] responseToBytes();
}
