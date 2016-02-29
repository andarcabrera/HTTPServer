import Server.HTTPServer;

import java.io.IOException;


public class StartServer {
    public static void main(String[] args) throws IOException {
        HTTPServer server = new HTTPServer();
        server.listen();
    }
}
