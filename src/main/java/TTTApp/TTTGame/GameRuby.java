package TTTApp.TTTGame;

import org.jruby.Ruby;
import org.jruby.javasupport.JavaEmbedUtils;
import org.jruby.runtime.builtin.IRubyObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by andacabrera29 on 3/31/16.
 */
public class GameRuby implements TTTGame {
    private Ruby runtime;
    private IRubyObject rootRubyObject;
    private IRubyObject game;
    private int size;

    public int getSize(){
        return size;
    }

    public String[] getMarkers(){
        return (String[]) JavaEmbedUtils.invokeMethod( runtime, game, "markers", new Object[] {}, String[].class );
    }

    public void play(){
        JavaEmbedUtils.invokeMethod( runtime, game, "play_game", new Object[] {}, IRubyObject.class );
    }

    public String[] getBoard(){
        String[] boardState = (String[]) JavaEmbedUtils.invokeMethod( runtime, game, "current_state", new Object[] {}, String[].class );
        return boardState;
    }

    public boolean gameOver(){
        Boolean over = (Boolean) JavaEmbedUtils.invokeMethod( runtime, game, "game_over?", new Object[] {}, Boolean.class );
        return over;
    }

    public void updateBoard(String[] currentState){
        JavaEmbedUtils.invokeMethod( runtime, game, "update_board_state", new Object[] {currentState}, String[].class );
    }

    public void setGame(Map<String, String> requestParams, String spot){
        System.out.println("do you get here?***************");
        Map<String, String> params = requestParams;
        size = Integer.parseInt(params.get("size"));

        String bootstrapSetup =
                "require_relative \"" + "../tttj_gem/lib/tttj/game_setup.rb" +  "\"\n"+
                        "class Bootstrap \n" +
                        "   def execute root_object, spot  \n" +
                        "       " + "TTT::GameSetup.new" + "(root_object, spot) \n" +
                        "   end    \n" +
                        "end \n" +
                        "Bootstrap.new";


        String bootstrapGame =
                "require_relative \"" + "../tttj_gem/lib/tttj/game.rb" +  "\"\n"+
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

        IRubyObject setup = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootRubyObject, "execute", new Object[] {params, spot}, IRubyObject.class );
        IRubyObject players = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, setup, "create_players", new Object[] {}, IRubyObject.class );
        System.out.println("how about here?");


        IRubyObject rootGame = JavaEmbedUtils.newRuntimeAdapter().eval( runtime, bootstrapGame );
        game = (IRubyObject) JavaEmbedUtils.invokeMethod( runtime, rootGame, "execute", new Object[] {players, size}, IRubyObject.class );
    }
}
