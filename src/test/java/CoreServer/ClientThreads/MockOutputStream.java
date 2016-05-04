package CoreServer.ClientThreads;

import CoreServer.IOStreams.HttpOutputStream;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class MockOutputStream implements HttpOutputStream{
    private StringBuffer messagesFromServer = new StringBuffer();

    public void writeMessage(byte[] message) {
        messagesFromServer.append(new String(message));
    }

    public String revealOutputStream() {
        return messagesFromServer.toString();
    }

    public void emptyStream() {
        messagesFromServer.delete(0, messagesFromServer.length());
    }
}
