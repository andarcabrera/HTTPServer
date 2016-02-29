package RequestHandling;

import Request.RequestBuilder;


public interface HandleAction {
    void setRequest(RequestBuilder request);
    String getResponse();
}
