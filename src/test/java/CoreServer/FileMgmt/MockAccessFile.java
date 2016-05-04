package CoreServer.FileMgmt;

/**
 * Created by andacabrera29 on 3/16/16.
 */
public class MockAccessFile implements FileAccess {
    @Override
    public byte[] readFromFile(String fileName) {
        return "Read from file".getBytes();
    }

    @Override
    public byte[] readPartiallyFromFile(String fileName, String rawRange) {
        return "Partially read from file".getBytes();
    }

    @Override
    public void writeToFile(String fileName, String message) {

    }

    @Override
    public void deleteFileContent(String fileName) {

    }
}
