package Controllers;

import Helpers.GameInfoParser;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.TTTGameOverView;
import Views.TTTHomePage;
import Views.TTTMakeMoveTTT;
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
    TTTGameOverView gameOverView = new TTTGameOverView();
    TTTMakeMoveTTT makeMoveView = new TTTMakeMoveTTT();
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
        int size = Integer.parseInt(params.get("size"));
        String[] markers = gameInfoParser.markers();

        String bootstrapSetup =
                "require \"" + "/Users/andacabrera29/Desktop/tttj_gem/lib/tttj/game_setup.rb" +  "\"\n"+
                        "class Bootstrap \n" +
                        "   def execute root_object  \n" +
                        "       " + "TTT::GameSetup.new" + "(root_object) \n" +
                        "   end    \n" +
                        "end \n" +
                        "Bootstrap.new";

        String bootstrapGame =
                "require \"" + "/Users/andacabrera29/Desktop/tttj_gem/lib/tttj/game.rb" +  "\"\n"+
                        "class Bootstrap \n" +
                        "   def execute root_object, size  \n" +
                        "       " + "TTT::Game.new" + "(root_object, size) \n" +
                        "   end    \n" +
                        "end \n" +
                        "Bootstrap.new";

        List<String> loadPaths = new ArrayList<String>();
        loadPaths.add(".");

        runtime = JavaEmbedUtils.initialize( loadPaths );
        rootRubyObject = JavaEmbedUtils.newRuntimeAdapter().eval( runtime, bootstrapSetup );

        IRubyObject setup = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootRubyObject, "execute", new Object[] {params}, IRubyObject.class );
        IRubyObject players = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, setup, "create_players", new Object[] {}, IRubyObject.class );
        System.out.println(players);

        IRubyObject rootGame = JavaEmbedUtils.newRuntimeAdapter().eval( runtime, bootstrapGame );
        IRubyObject game = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootGame, "execute", new Object[] {players, size}, IRubyObject.class );
        JavaEmbedUtils.invokeMethod( runtime, game, "play_game", new Object[] {}, IRubyObject.class );
        String[] board = (String[]) JavaEmbedUtils.invokeMethod( runtime, game, "current_state", new Object[] {}, String[].class );
        Boolean gameOver = (Boolean) JavaEmbedUtils.invokeMethod( runtime, game, "game_over?", new Object[] {}, Boolean.class );

        if (gameOver){
            response.setStatusCode("OK");
            response.setResponseBody(gameOverView.generateHtml(size, markers, board));
            return response;
        } else {
            response.setStatusCode("OK");
            response.setResponseBody(makeMoveView.generateHtml(size, markers, board));
            return response;
        }
//        System.out.println((IRubyObject) JavaEmbedUtils.invokeMethod( runtime, game, "game_over?", new Object[] {}, IRubyObject.class ));
//        System.out.println((IRubyObject) JavaEmbedUtils.invokeMethod( runtime, game, "markers", new Object[] {}, IRubyObject.class ));
//        System.out.println((IRubyObject) JavaEmbedUtils.invokeMethod( runtime, game, "size", new Object[] {}, IRubyObject.class ));

    }
}
