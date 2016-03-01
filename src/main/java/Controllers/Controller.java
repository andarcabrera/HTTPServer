package Controllers;

/**
 * Created by andacabrera29 on 2/29/16.
 */
public interface Controller {
    public String sendResponse();
    public String get(String action);
    public String post(String action, String instructions);
    public String put(String action, String instructions);
    public String delete(String action, String instructions);
}
