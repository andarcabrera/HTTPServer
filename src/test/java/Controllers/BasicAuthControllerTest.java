package Controllers;

import Helpers.Base64ParserAndDecoder;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by andacabrera29 on 3/17/16.
 */
public class BasicAuthControllerTest {
    private BasicAuthController basicAuthController;
    private RequestBuilder request;
    private ResponseBuilder response;
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
        basicAuthController = new BasicAuthController(request, response, decoder);

        assertEquals("UnauthorizedWWW-Authenticate: Basic realm=\"CobSpec Realm\"", new String(basicAuthController.sendResponse().responseToBytes()).trim());
    }

    @Test
    public void testGetWithWrongAuthorizationHeader() throws Exception {
        requestDetails.append("method~GET  url~/  Authorization~ Basic MWRtaW46aHVudGVyMg==");
        request.buildRequest(requestDetails);
        basicAuthController = new BasicAuthController(request, response, decoder);

        assertEquals("UnauthorizedWWW-Authenticate: Basic realm=\"CobSpec Realm\"", new String(basicAuthController.sendResponse().responseToBytes()).trim());
    }

    @Test
    public void testGetWithCorrectAuthorizationHeader() throws Exception {
        requestDetails.append("method~GET  url~/  Authorization~Basic YWRtaW46aHVudGVyMg==");
        request.buildRequest(requestDetails);
        basicAuthController = new BasicAuthController(request, response, decoder);

        assertTrue(new String(basicAuthController.sendResponse().responseToBytes()).trim().startsWith("OK"));
    }

}