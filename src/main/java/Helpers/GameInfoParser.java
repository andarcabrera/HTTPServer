package Helpers;

import java.util.HashMap;

/**
 * Created by andacabrera29 on 3/23/16.
 */
public class GameInfoParser {
    private String rawGameInfo;
    private HashMap<String, String> params = new HashMap<>();

    public HashMap<String, String> getParams(String rawParamsInfo){
        parsePlayerInfo(rawParamsInfo);
        return  params;
    }

    public String[] markers(){
        String[] game_markers = new String[2];
        game_markers[0] = params.get("player1_marker");
        game_markers[1] = params.get("player2_marker");
        return game_markers;
    }

    private void parsePlayerInfo(String rawInfo){
        toParams(rawInfo);
    }

    private void toParams(String info){
        String[] parsedInfo = info.split("&");
        for (int i=0; i<parsedInfo.length; i++){
            getParam(parsedInfo[i]);
        }
    }

    private void getParam(String paramInfo){
        String[] splitParam = paramInfo.split("=");
        params.put(splitParam[0], splitParam[1]);
    }
}


