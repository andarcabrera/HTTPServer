package Controllers;

import Helpers.GameInfoParser;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.TTTHomePage;
import org.jruby.Ruby;
import org.jruby.javasupport.JavaEmbedUtils;
import org.jruby.runtime.builtin.IRubyObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by andacabrera29 on 3/23/16.
 */
public class TTTController extends Controller{
    TTTHomePage index = new TTTHomePage();
    GameInfoParser gameInfoParser = new GameInfoParser();
    private IRubyObject rootRubyObject;
    private Ruby runtime;

    public TTTController(RequestBuilder request, ResponseBuilder response){
        super(request, response);
    }

    public ResponseBuilder get(RequestBuilder request) {
        response.setStatusCode("OK");
        response.setResponseBody(index.homePageHtml());
        return response;
    }

    public ResponseBuilder post(RequestBuilder request) {
        Map<String, String> params = gameInfoParser.getParams(request.getRawBody());
        String size = params.get("size");

        String bootstrap =
                "require \"" + "/Users/andacabrera29/Desktop/test.rb" +  "\"\n"+
                        "class Bootstrap \n" +
                        "   def execute root_object  \n" +
                        "       " + "Hello.new" + "(root_object) \n" +
                        "   end    \n" +
                        "end \n" +
                        "Bootstrap.new";

        List<String> loadPaths = new ArrayList<String>();
        loadPaths.add(".");

        runtime = JavaEmbedUtils.initialize( loadPaths );
        rootRubyObject = JavaEmbedUtils.newRuntimeAdapter().eval( runtime, bootstrap );

        IRubyObject hello = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootRubyObject, "execute", new Object[] {"Anda"}, IRubyObject.class );
        System.out.println(JavaEmbedUtils.invokeMethod( runtime, hello, "start", new Object[] {params}, IRubyObject.class ));


        response.setStatusCode("OK");
        response.setResponseBody(index.homePageHtml());
        return response;
    }
}
