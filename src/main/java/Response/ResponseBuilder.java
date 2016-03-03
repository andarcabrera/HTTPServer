package Response;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public interface ResponseBuilder {
    public void setStatusCode(Integer code);
    public void addHeader(String header);
    public void setResponseBody(byte[] bodyContent);
    public byte[] responseToBytes();
}
