package CoreServer.Router;

/**
 * Created by andacabrera29 on 5/2/16.
 */
public class MockRoute implements Route {
    @Override
    public String getRequestAction() {
        return "routeRequestAction";
    }

    @Override
    public String getControllerName() {
        return "routeControlerName";
    }

    @Override
    public String getControllerAction() {
        return "routeControllerAction";
    }

    @Override
    public String getRouteMethod() {
        return "routeMethod";
    }

    @Override
    public String getRouteURL() {
        return "routeURL";
    }
}
