package Request;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class RequestProcessor implements InfoProcessor {
    private StringBuffer rawRequest;
    private RequestBuilder request;

    public RequestProcessor(RequestBuilder requestBuilder){
        this.request = requestBuilder;
    }

    public void handleRequest(StringBuffer rawRequest){
        request.buildRequest(rawRequest);
    }

    public RequestBuilder getRequest(){
        return request;
    }

}
