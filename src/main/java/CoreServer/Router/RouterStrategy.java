package CoreServer.Router;

import CoreServer.Request.Request;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public interface RouterStrategy {
    void route(Request request);
    byte[] getResponse();
}
