package ClientThreads;

import Controllers.*;
import FileMgmt.FileAccess;
import Helpers.Base64ParserAndDecoder;
import Helpers.Parser;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import TTT.TTTGame;
import Views.AbstractViewFactory;

/**
 * Created by andacabrera29 on 3/15/16.
 */
public class MockControllerFactory extends AbstractControllerFactory{

    @Override
    public Controller createController(String controllerName, RequestBuilder request, ResponseBuilder response) {
        return new MockController(request, response);
    }
}
