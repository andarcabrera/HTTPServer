package Views;

import java.util.HashMap;


public class StatusCodes {
    public static final HashMap<String, String> statusCodes = new HashMap<>();

    private static void populateStatusCodes(){
        statusCodes.put("OK", "200 OK");
        statusCodes.put("PartialContent", "206 Partial Content");
        statusCodes.put("PageNotFound", "404 Not Found");
        statusCodes.put("MethodNotAllowed", "405 Method Not Allowed");
        statusCodes.put("Redirect", "302 Found");
    }

    public static String getStatus(String status){
        populateStatusCodes();
        return statusCodes.get(status);
    }
}
