package CoreServer.Router;

/**
 * Created by andacabrera29 on 5/2/16.
 */
public interface Route {
    String getRequestAction();
    String getControllerName();
    String getControllerAction();
    String getRouteMethod();
    String getRouteURL();
}
