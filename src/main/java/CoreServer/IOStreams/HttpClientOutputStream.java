package CoreServer.IOStreams;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class HttpClientOutputStream implements HttpOutputStream{
    private DataOutputStream output = null;

    public HttpClientOutputStream(DataOutputStream output) {
        this.output = output;
    }

    public void writeMessage(byte[] message) {
        try {
            output.write(message);
            output.flush();
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
