package ClientThreads;

import Controllers.Controller;
import Request.RequestBuilder;
import Response.ResponseBuilder;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockController extends Controller {
    public MockController(RequestBuilder request, ResponseBuilder response) {
        super(request, response);
    }

    public ResponseBuilder get(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response;
    }

    public ResponseBuilder post(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response;
    }

    public ResponseBuilder put(RequestBuilder request) {
        response.setStatusCode("PageNotFound");
        return response;
    }
}
