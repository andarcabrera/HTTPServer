package Router;

import Request.Request;
import RequestHandling.HandleGet;
import RequestHandling.Handler;

import java.util.ArrayList;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class Router {
    ArrayList<Handler> handlers = new ArrayList<Handler>();
    private HandleGet handleGet = new HandleGet();

    public void route(Request request) {
        switch (request.getMethod()) {
            case "GET":
                handleGet.setRequest(request);
                break;
        }
    }

    public String getResponse(){
        return handleGet.getResponse();
    }
}
