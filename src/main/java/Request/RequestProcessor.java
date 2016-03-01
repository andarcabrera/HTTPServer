package Request;

import Router.Router;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class RequestProcessor implements InfoProcessor {
    private StringBuffer rawRequest;
    private Request request;
    private Router router = new Router();


    public void handleRequest(StringBuffer rawRequest){
        this.request = new Request(rawRequest);
        setRawRequest(rawRequest);
        router.route(request);
    }

    public void setRawRequest(StringBuffer rawRequest){
        this.rawRequest = rawRequest;
    }

    public String response(){
        return router.getResponse();
    }
}
