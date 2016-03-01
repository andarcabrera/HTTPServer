package IOStreams;

import java.io.PrintWriter;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class HttpClientOutputStream implements HttpOutputStream{
    PrintWriter output = null;

    public HttpClientOutputStream(PrintWriter output) {
        this.output = output;
    }

    public void writeMessage(String message) {
        output.print(message);
        output.flush();
        output.close();
    }
}
