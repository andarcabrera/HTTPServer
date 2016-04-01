package Helpers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by andacabrera29 on 3/30/16.
 */
public class CookieParser implements Parser{
    private Map<String, String> cookieInfo = new HashMap<>();

    public Map<String, String> getParsedInfo(String cookie){
        String[] parsedCookie = cookie.split(";");
        populateCookieInfo(parsedCookie);
        return cookieInfo;
    }

    private void populateCookieInfo(String[] rawCookie){
        for (int i = 0; i < rawCookie.length ;i++){
            String[] splitInfo = rawCookie[i].split("=:");
            if (splitInfo.length == 2) {
                String cookieName = splitInfo[0].trim();
                String cookieValue = splitInfo[1];
                cookieInfo.put(cookieName, cookieValue);
            }
        }
    }
}
