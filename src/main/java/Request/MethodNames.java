package Request;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by andacabrera29 on 2/26/16.
 */
public class MethodNames {
    public static final ArrayList<String> methodNames = new ArrayList<String>(
            Arrays.asList("GET", "POST", "PUT", "DELETE"));

    public static boolean contains(String request, int i, int j){
        return methodNames.contains(request.substring(i, j));
    }
}
