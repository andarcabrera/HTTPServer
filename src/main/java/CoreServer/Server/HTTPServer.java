package CoreServer.Server;

import CobSpecApp.Config.CobspecRoutes;
import CoreServer.ClientThreads.HandleUserThread;
import CoreServer.Controllers.AbstractControllerFactory;
import CobSpecApp.Controllers.CobSpecControllerFactory;
import CobSpecApp.Config.RequestLogger;
import CoreServer.IOStreams.HttpClientInputStream;
import CoreServer.IOStreams.HttpClientOutputStream;
import CoreServer.IOStreams.HttpInputStream;
import CoreServer.IOStreams.HttpOutputStream;
import CoreServer.Request.InfoProcessor;
import CoreServer.Request.Request;
import CoreServer.Request.RequestBuilder;
import CoreServer.Request.RequestProcessor;
import CoreServer.Response.HttpServerResponse;
import CoreServer.Response.Response;
import CoreServer.Router.HttpRouter;
import CoreServer.Router.RouterStrategy;
import CoreServer.Router.RoutesConfig;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HTTPServer {
    ExecutorService executor = Executors.newFixedThreadPool(8);

    public void listen(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);

        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                RequestLogger.resetLog();
                executor.shutdown();
            }
        });

        try {
            while (true) {
                Socket userSocket = server.accept();

                DataOutputStream dataOutputStream = new DataOutputStream(userSocket.getOutputStream());
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));

                HttpInputStream userInputStream = new HttpClientInputStream(inputReader);
                HttpOutputStream userOutputStream = new HttpClientOutputStream(dataOutputStream);

                RequestBuilder requestBuilder = new Request();
                InfoProcessor requestProcessor = new RequestProcessor(requestBuilder);

                AbstractControllerFactory controllerFactory = new CobSpecControllerFactory();
                Response responseBuilder = new HttpServerResponse();
                RoutesConfig routesSetup = new CobspecRoutes();
                RouterStrategy router = new HttpRouter(controllerFactory, responseBuilder, routesSetup);

                executor.execute(new HandleUserThread(userInputStream, userOutputStream, requestProcessor, router));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.close();
        }
    }
}