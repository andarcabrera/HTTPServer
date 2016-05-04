package CoreServer.IOStreams;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class HttpClientInputStream implements HttpInputStream {
    private BufferedReader input = null;

    public HttpClientInputStream(BufferedReader input) {
        this.input = input;
    }

    @Override
    public int read() {
        int bitChar = 0;
        try {
            bitChar = input.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitChar;
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
