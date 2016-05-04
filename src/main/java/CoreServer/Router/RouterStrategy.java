package CoreServer.Router;

import CoreServer.Request.Request;

import java.lang.reflect.InvocationTargetException;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public interface RouterStrategy {
    void route(Request request);
    byte[] getResponse() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException;
}
