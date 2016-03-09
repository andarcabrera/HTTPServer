import Server.HTTPServer;
import SetUp.SetUp;

import java.io.IOException;


public class StartServer {
    public static void main(String[] args) throws IOException {
        HTTPServer server = new HTTPServer();
        SetUp serverSetup = new SetUp(args);

        int port = serverSetup.getPort();
        server.listen(port);
    }
}
