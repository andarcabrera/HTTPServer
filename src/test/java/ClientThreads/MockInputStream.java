package ClientThreads;

import IOStreams.HttpInputStream;

/**
 * Created by andacabrera29 on 2/25/16.
 */
public class MockInputStream implements HttpInputStream {
    byte[] message;
    int counter = 0;

    @Override
    public int read() {
        int messageBit = message[counter];
        counter += 1;
        return messageBit;
    }

    @Override
    public boolean ready() {
        return !(counter == message.length);
    }

    public void addInput(String a) {
        message = a.getBytes();
    }
}
