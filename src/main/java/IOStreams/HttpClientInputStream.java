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

    @Override
    public char read() {
        int bitChar = 0;
        try {
            bitChar = input.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return (char) bitChar;
    }

    @Override
    public String readLine() {
        String line = null;
        try {
            line = input.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
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
