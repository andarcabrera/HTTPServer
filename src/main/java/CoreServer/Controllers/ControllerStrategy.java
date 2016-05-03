package CoreServer.Controllers;

import CoreServer.Response.Response;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public interface ControllerStrategy {
    public Response sendResponse(String action);
}
