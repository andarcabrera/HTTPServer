package Controllers;

/**
 * Created by andacabrera29 on 2/29/16.
 */
public interface Controller {
    public byte[] sendResponse();
    public byte[] get(String action);
    public byte[] post(String action, String instructions);
    public byte[] put(String action, String instructions);
}
