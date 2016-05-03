package CoreServer.Response;

import java.util.HashMap;


public class StatusCodes {
    public static final HashMap<String, String> statusCodes = new HashMap<String, String>() {{
        put("OK", "200 OK");
        put("PartialContent", "206 Partial Content");
        put("PageNotFound", "404 Not Found");
        put("MethodNotAllowed", "405 Method Not Allowed");
        put("Redirect", "302 Found");
        put("NoContent", "204 No Content");
        put("Unauthorized", "401 Unauthorized");
        put("Teapot", "418 I'm a teapot");
    }};
}
