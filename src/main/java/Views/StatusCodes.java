package Views;

import java.util.HashMap;


public class StatusCodes {
    public static final HashMap<Integer, String> statusCodes = new HashMap<Integer, String>();

    private static void populateStatusCodes(){
        statusCodes.put(200, "200 OK");
        statusCodes.put(206, "206 Partial Content");
        statusCodes.put(404, "404 Not Found");
        statusCodes.put(405, "405 Method Not Allowed");
        statusCodes.put(406, "406 Not Acceptable");
        statusCodes.put(451, "451 Redirect");
    }

    public static String getStatus(Integer code){
        populateStatusCodes();
        return statusCodes.get(code);
    }
}
