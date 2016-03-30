package Controllers;

import Helpers.CookieParser;
import Helpers.GameInfoParser;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import Views.TTTGameOverView;
import Views.TTTHomePage;
import Views.TTTMakeMoveView;
import org.jruby.Ruby;
import org.jruby.javasupport.JavaEmbedUtils;
import org.jruby.runtime.builtin.IRubyObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TTTController extends Controller{
    private int sessionSize;
    static String[] sessionBoard;
    private Map<String, String> sessionGameInfo;
    private String[] sessionMarkers;

    TTTHomePage index = new TTTHomePage();
    TTTGameOverView gameOverView = new TTTGameOverView();
    TTTMakeMoveView makeMoveView = new TTTMakeMoveView();
    GameInfoParser gameInfoParser = new GameInfoParser();
    CookieParser cookieParser = new CookieParser();
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
        sessionGameInfo = params;

        int size = Integer.parseInt(params.get("size"));
        sessionSize = size;

        String[] markers = gameInfoParser.markers();
        sessionMarkers = markers;

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

        List<String> loadPaths = new ArrayList<>();
        loadPaths.add(".");

        runtime = JavaEmbedUtils.initialize( loadPaths );
        rootRubyObject = JavaEmbedUtils.newRuntimeAdapter().eval( runtime, bootstrapSetup );

        IRubyObject setup = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootRubyObject, "execute", new Object[] {params}, IRubyObject.class );
        IRubyObject players = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, setup, "create_players", new Object[] {}, IRubyObject.class );

        IRubyObject rootGame = JavaEmbedUtils.newRuntimeAdapter().eval( runtime, bootstrapGame );
        IRubyObject game = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootGame, "execute", new Object[] {players, size}, IRubyObject.class );
        JavaEmbedUtils.invokeMethod( runtime, game, "play_game", new Object[] {}, IRubyObject.class );
        String[] board = (String[]) JavaEmbedUtils.invokeMethod( runtime, game, "current_state", new Object[] {}, String[].class );
        Boolean gameOver = (Boolean) JavaEmbedUtils.invokeMethod( runtime, game, "game_over?", new Object[] {}, Boolean.class );

        sessionBoard = board;

        response.addHeader("Set-Cookie", "game_info=:" + request.getRawBody());
//        response.addHeader("Set-Cookie", "filled_spots=:spots");


        if (gameOver){
            response.setStatusCode("OK");
            response.setResponseBody(gameOverView.generateHtml(size, markers, board));
            return response;
        } else {
            response.setStatusCode("OK");
            response.setResponseBody(makeMoveView.generateHtml(size, markers, board));
            return response;
        }
    }

    public ResponseBuilder put(RequestBuilder request) {
        String spot = gameInfoParser.getSpot(request.getUrl());
        Map<String, String> cookie = cookieParser.getCookieInfo(request.getHeaders().get("Cookie"));
        String parsedCookie = cookie.get("game_info");
        String filledSpots = cookie.get("filled_spots");
        System.out.println(filledSpots);

        Map<String, String> params = gameInfoParser.getParams(parsedCookie);
        sessionGameInfo = params;

        int size = Integer.parseInt(params.get("size"));
        sessionSize = size;

        String[] markers = gameInfoParser.markers();
        sessionMarkers = markers;


        String bootstrapSetup =
                "require \"" + "/Users/andacabrera29/Desktop/tttj_gem/lib/tttj/game_setup.rb" +  "\"\n"+
                        "class Bootstrap \n" +
                        "   def execute root_object, spot  \n" +
                        "       " + "TTT::GameSetup.new" + "(root_object, spot) \n" +
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

        List<String> loadPaths = new ArrayList<>();
        loadPaths.add(".");

        runtime = JavaEmbedUtils.initialize( loadPaths );
        rootRubyObject = JavaEmbedUtils.newRuntimeAdapter().eval( runtime, bootstrapSetup );

        IRubyObject setup = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootRubyObject, "execute", new Object[] {sessionGameInfo, spot}, IRubyObject.class );
        IRubyObject players = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, setup, "create_players", new Object[] {}, IRubyObject.class );


        IRubyObject rootGame = JavaEmbedUtils.newRuntimeAdapter().eval( runtime, bootstrapGame );
        IRubyObject game = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootGame, "execute", new Object[] {players, sessionSize}, IRubyObject.class );
        JavaEmbedUtils.invokeMethod( runtime, game, "update_board_state", new Object[] {sessionBoard}, String[].class );
        JavaEmbedUtils.invokeMethod( runtime, game, "play_game", new Object[] {}, IRubyObject.class );
        String[] board = (String[]) JavaEmbedUtils.invokeMethod( runtime, game, "current_state", new Object[] {}, String[].class );
        Boolean gameOver = (Boolean) JavaEmbedUtils.invokeMethod( runtime, game, "game_over?", new Object[] {}, Boolean.class );

        sessionBoard = board;

        response.addHeader("Set-Cookie", "filled_spots=:" + filledSpots + spot );

        if (gameOver){
            response.setStatusCode("OK");
            response.setResponseBody(gameOverView.generateHtml(sessionSize, sessionMarkers, board));
            return response;
        } else {
            response.setStatusCode("OK");
            response.setResponseBody(makeMoveView.generateHtml(sessionSize, sessionMarkers, board));
            return response;
        }
    }
}
