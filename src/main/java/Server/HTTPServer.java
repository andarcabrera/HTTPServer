package Server;

import ClientThreads.HandleUserThread;
import Helpers.RequestLogger;
import IOStreams.HttpClientInputStream;
import IOStreams.HttpClientOutputStream;
import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;
import Request.InfoProcessor;
import Request.RequestProcessor;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;


public class HTTPServer {
    private Hashtable<Thread, Socket> allThreads = new Hashtable<Thread, Socket>();
    public void listen(int port) throws IOException {
        ServerSocket server = new ServerSocket(port);

        try {
            while (true) {
                Socket userSocket = server.accept();

                Runtime.getRuntime().addShutdownHook(new Thread() {
                    public void run() {
                        System.out.println("Shut down hook started to close all threads.");
                        RequestLogger.resetLog();
                        stopAllThreads();
                        System.out.println("Shutdown hook completed :).");
                    }
                });


                DataOutputStream dataOutputStream = new DataOutputStream(userSocket.getOutputStream());
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));

                HttpInputStream userInputStream = new HttpClientInputStream(inputReader);
                HttpOutputStream userOutputStream = new HttpClientOutputStream(dataOutputStream);

                InfoProcessor requestProcessor = new RequestProcessor();

                Thread userThread = new Thread(new HandleUserThread(userInputStream, userOutputStream, requestProcessor));
                allThreads.put(userThread, userSocket);

                userThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            server.close();
        }
    }

    private void stopAllThreads() {
        synchronized (allThreads) {
            Enumeration<Thread> enumKey = allThreads.keys();
            while (enumKey.hasMoreElements()) {
                Thread thread = enumKey.nextElement();
                Socket socket = allThreads.get(thread);
                try {
                    socket.close();
                    thread.join();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
