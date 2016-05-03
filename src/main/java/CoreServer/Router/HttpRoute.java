package CoreServer.Router;

/**
 * Created by andacabrera29 on 4/29/16.
 */
public class HttpRoute implements Route {
    private String requestAction;
    private String controllerName;
    private String controllerAction;

    public HttpRoute(String requestAction, String controllerName, String controllerAction){
        this.requestAction = requestAction;
        this.controllerName = controllerName;
        this.controllerAction = controllerAction;
    }

    public String getRequestAction() {
        return requestAction;
    }

    public String getControllerName() {
        return controllerName;
    }

    public  String getControllerAction() {
        return controllerAction;
    }

    public String getRouteMethod(){
        return requestAction.split(" ")[0];
    }

    public String getRouteURL(){
        return requestAction.split(" ")[1];
    }
}
