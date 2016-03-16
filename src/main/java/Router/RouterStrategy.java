package Router;

import Request.RequestBuilder;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public interface RouterStrategy {
    void route(RequestBuilder request);
    byte[] getResponse();
}
