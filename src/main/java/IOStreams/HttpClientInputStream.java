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
        String message = null;
        try {
            message = input.readLine();
        } catch (IOException e) {
            System.out.println("Caught socket closed exception!");
//            e.printStackTrace();
        }
        return message;
    }
}
