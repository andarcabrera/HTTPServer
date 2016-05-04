package CobSpecApp.Controllers;

import CobSpecApp.Controllers.BasicAuthController;
import CobSpecApp.Parsers.Base64ParserAndDecoder;
import CoreServer.Controllers.MockRequest;
import CoreServer.Controllers.MockResponse;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/17/16.
 */
public class BasicAuthControllerTest {
    private BasicAuthController basicAuthController;
    private Request request;
    private Response response;
    private Base64ParserAndDecoder decoder;
    private StringBuffer requestDetails;

    @Before
    public void setUp(){
        request = new MockRequest();
        requestDetails = new StringBuffer();
        response = new MockResponse();
        decoder = new Base64ParserAndDecoder();
    }

    @Test
    public void testGetNoAuthorizationHeader() throws Exception {
        requestDetails.append("method~GET  url~/");
        request.buildRequest(requestDetails);
        basicAuthController = new BasicAuthController(request, response, "", decoder);

        assertEquals("UnauthorizedWWW-Authenticate: Basic realm=\"CobSpec Realm\"", new String(basicAuthController.sendResponse("getSecureResponse").responseToBytes()).trim());
    }

    @Test
    public void testGetWithWrongAuthorizationHeader() throws Exception {
        requestDetails.append("method~GET  url~/  Authorization~ Basic MWRtaW46aHVudGVyMg==");
        request.buildRequest(requestDetails);
        basicAuthController = new BasicAuthController(request, response, "", decoder);

        assertEquals("UnauthorizedWWW-Authenticate: Basic realm=\"CobSpec Realm\"", new String(basicAuthController.sendResponse("getSecureResponse").responseToBytes()).trim());
    }

    @Test
    public void testGetWithCorrectAuthorizationHeader() throws Exception {
        requestDetails.append("method~GET  url~/  Authorization~Basic YWRtaW46aHVudGVyMg==");
        request.buildRequest(requestDetails);
        basicAuthController = new BasicAuthController(request, response, "", decoder);

        assertTrue(new String(basicAuthController.sendResponse("getSecureResponse").responseToBytes()).trim().startsWith("OK"));
    }

}