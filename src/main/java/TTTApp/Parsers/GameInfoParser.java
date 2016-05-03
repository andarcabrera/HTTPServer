package TTTApp.Parsers;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by andacabrera29 on 3/23/16.
 */
public class GameInfoParser{
    private HashMap<String, String> params = new HashMap<>();

    public Map<String, String> getParsedInfo(String rawParamsInfo){
        parsePlayerInfo(rawParamsInfo);
        return  params;
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


