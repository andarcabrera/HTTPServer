package CoreServer.Response;

import java.util.HashMap;


public class StatusCodes {
    public static final HashMap<String, String> statusCodes = new HashMap<>();

    private static void populateStatusCodes(){
        statusCodes.put("OK", "200 OK");
        statusCodes.put("PartialContent", "206 Partial Content");
        statusCodes.put("PageNotFound", "404 Not Found");
        statusCodes.put("MethodNotAllowed", "405 Method Not Allowed");
        statusCodes.put("Redirect", "302 Found");
        statusCodes.put("NoContent", "204 No Content");
        statusCodes.put("Unauthorized", "401 Unauthorized");
        statusCodes.put("Teapot", "418 I'm a teapot");
    }

    public static String getStatus(String status){
        populateStatusCodes();
        return statusCodes.get(status);
    }
}
