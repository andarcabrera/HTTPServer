package IOStreams;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class HttpClientInputStream implements HttpInputStream {
    BufferedReader input = null;

    public HttpClientInputStream(BufferedReader input) {
        this.input = input;
    }

    public String readMessage() {
        int request = 0;
        try {
            request = input.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf((char) request);
    }

    public boolean ready(){
        boolean isReady = false;
        try {
             isReady = input.ready();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return isReady;
    }
}
