import CobSpecApp.Config.CobspecRoutes;
import CobSpecApp.Config.RequestLogger;
import CobSpecApp.Controllers.CobSpecControllerFactory;
import CoreServer.Controllers.AbstractControllerFactory;
import CoreServer.Router.RoutesConfig;
import CoreServer.Server.HTTPServer;
import SetUp.SetUp;

import java.io.IOException;


public class StartServer {
    public static void main(String[] args) throws IOException {
        RequestLogger.init();

        SetUp serverSetup = new SetUp(args);

        int port = serverSetup.getPort();

        AbstractControllerFactory controllerFactory = serverSetup.getControllerFactory();
        RoutesConfig routesSetup = serverSetup.getRoutesConfig();

        HTTPServer server = new HTTPServer(controllerFactory, routesSetup);
        server.listen(port);
    }
}
