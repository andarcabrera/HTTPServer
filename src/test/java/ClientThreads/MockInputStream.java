package ClientThreads;

import IOStreams.HttpInputStream;

import java.util.ArrayList;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class MockInputStream implements HttpInputStream {
    ArrayList<String> request = new ArrayList<String>();
    private boolean isReady = true;

    public String readMessage() {
        String message;
        if (request.size() >= 1) {
            message = request.get(0);
            request.remove(0);
        } else {
            isReady = false;
            message = "";
        }
        return message;
    }

    @Override
    public boolean ready() {
        return isReady;
    }

    public void emptyStream() {
        request.clear();
    }

    public void addInput(String a) {
        request.add(a);
    }
}
