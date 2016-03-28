import Helpers.RequestLogger;
import Server.HTTPServer;
import SetUp.SetUp;

import java.io.IOException;


public class StartServer {
    public static void main(String[] args) throws IOException {
        RequestLogger.init();

        SetUp serverSetup = new SetUp(args);

        int port = serverSetup.getPort();

        HTTPServer server = new HTTPServer();
        server.listen(port);



    }
}
