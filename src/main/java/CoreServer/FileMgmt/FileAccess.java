package CoreServer.FileMgmt;

/**
 * Created by andacabrera29 on 3/16/16.
 */
public interface FileAccess {
    byte[] readFromFile(String fileName);
    byte[] readPartiallyFromFile(String fileName, String rawRange);
    void writeToFile(String fileName, String message);
    void deleteFileContent(String fileName);
}
