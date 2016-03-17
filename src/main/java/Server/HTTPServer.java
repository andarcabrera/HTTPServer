package Server;

import ClientThreads.HandleUserThread;
import Controllers.AbstractControllerFactory;
import Controllers.ControllerFactory;
import Helpers.RequestLogger;
import IOStreams.HttpClientInputStream;
import IOStreams.HttpClientOutputStream;
import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;
import Request.InfoProcessor;
import Request.Request;
import Request.RequestBuilder;
import Request.RequestProcessor;
import Response.HttpServerResponse;
import Response.ResponseBuilder;
import Router.Router;
import Router.RouterStrategy;
import Router.RoutesSetup;
import Router.TrackRoutes;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class HTTPServer {
//    private Hashtable<Thread, Socket> allThreads = new Hashtable<Thread, Socket>();
    ExecutorService executor = Executors.newCachedThreadPool();

    public void listen(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);

        try {
            while (true) {
                Socket userSocket = server.accept();

                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        RequestLogger.resetLog();
//                        stopAllThreads();
                        executor.shutdown();
                    }
                });


                DataOutputStream dataOutputStream = new DataOutputStream(userSocket.getOutputStream());
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));

                HttpInputStream userInputStream = new HttpClientInputStream(inputReader);
                HttpOutputStream userOutputStream = new HttpClientOutputStream(dataOutputStream);


                RequestBuilder requestBuilder = new Request();
                InfoProcessor requestProcessor = new RequestProcessor(requestBuilder);

                AbstractControllerFactory controllerFactory = new ControllerFactory();
                ResponseBuilder responseBuilder = new HttpServerResponse();
                TrackRoutes routesSetup = new RoutesSetup();
                RouterStrategy router = new Router(controllerFactory, responseBuilder, routesSetup);

//                Thread userThread = new Thread(new HandleUserThread(userInputStream, userOutputStream, requestProcessor, router));

                //HandleUserThread userThread = new HandleUserThread(userInputStream, userOutputStream, requestProcessor, router);
//                allThreads.put(userThread, userSocket);

                executor.execute(new HandleUserThread(userInputStream, userOutputStream, requestProcessor, router));
//                userThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.close();
        }
    }

//    private void stopAllThreads() {
//        synchronized (allThreads) {
//            Enumeration<Thread> enumKey = allThreads.keys();
//            while (enumKey.hasMoreElements()) {
//                Thread thread = enumKey.nextElement();
//                Socket socket = allThreads.get(thread);
//                try {
//                    socket.close();
//                    thread.join();
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//    }
}
