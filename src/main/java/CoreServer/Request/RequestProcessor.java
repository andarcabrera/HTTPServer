package CoreServer.Request;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class RequestProcessor implements InfoProcessor {
    private Request request;

    public RequestProcessor(Request requestBuilder){
        this.request = requestBuilder;
    }

    public void handleRequest(StringBuffer rawRequest){
        request.buildRequest(rawRequest);
    }

    public Request getRequest(){
        return request;
    }

}
