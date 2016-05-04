package CoreServer.Controllers;

import CoreServer.Response.Response;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by andacabrera29 on 3/3/16.
 */
public interface ControllerStrategy {
    Response sendResponse(String action) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException;
}
