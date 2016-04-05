package Request;

import Controllers.MockRequest;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;



/**
 * Created by andacabrera29 on 3/16/16.
 */
public class RequestProcessorTest {
    private RequestProcessor requestProcessor;
    private RequestBuilder requestBuilder;
    private StringBuffer rawRequest;

    @Before
    public void setUp(){
        requestBuilder = new MockRequest();
        requestProcessor = new RequestProcessor(requestBuilder);
        rawRequest = new StringBuffer();
    }

    @Test
    public void testGetRequest() throws Exception {
        String testRequest = "method~method  url~action  rawBody~body";
        rawRequest.append(testRequest);
        requestProcessor.handleRequest(rawRequest);
        assertEquals("body", requestProcessor.getRequest().getRawBody());
    }
}