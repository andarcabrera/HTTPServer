package CoreServer.Server;


import CoreServer.ClientThreads.HandleUserThread;
import CoreServer.Controllers.AbstractControllerFactory;
import CobSpecApp.Config.RequestLogger;
import CoreServer.IOStreams.HttpClientInputStream;
import CoreServer.IOStreams.HttpClientOutputStream;
import CoreServer.IOStreams.HttpInputStream;
import CoreServer.IOStreams.HttpOutputStream;
import CoreServer.Request.InfoProcessor;
import CoreServer.Request.HttpRequest;
import CoreServer.Request.Request;
import CoreServer.Request.RequestProcessor;
import CoreServer.Response.HttpResponse;
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
    AbstractControllerFactory controllerFactory;
    RoutesConfig routesSetup;

    public HTTPServer(AbstractControllerFactory controllerFactory, RoutesConfig routesConfig) {
        this.controllerFactory =controllerFactory;
        this.routesSetup = routesConfig;
    }

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

                Request requestBuilder = new HttpRequest();
                InfoProcessor requestProcessor = new RequestProcessor(requestBuilder);

                Response responseBuilder = new HttpResponse();
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