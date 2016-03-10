import Logger.Logger;
import Server.HTTPServer;
import SetUp.SetUp;

import java.io.IOException;


public class StartServer {
    public static void main(String[] args) throws IOException {
        Logger logger = new Logger("/Users/andacabrera29/Desktop/logger");
        System.out.println("Server Started");


        SetUp serverSetup = new SetUp(args);

        int port = serverSetup.getPort();

        HTTPServer server = new HTTPServer();
        server.listen(port);

    }
}
