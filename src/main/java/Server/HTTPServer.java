package Server;

import IOStreams.HttpClientInputStream;
import IOStreams.HttpClientOutputStream;
import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;
import Request.InfoProcessor;
import Request.RequestProcessor;
import RequestHandling.HandleUserThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


public class HTTPServer {
    public void listen() throws IOException {
        ServerSocket chatServer = new ServerSocket(5000);

        try {
            while (true) {
                Socket userSocket = chatServer.accept();

                PrintWriter printWriter = new PrintWriter(userSocket.getOutputStream(), true);
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));

                HttpInputStream userInputStream = new HttpClientInputStream(inputReader);
                HttpOutputStream userOutputStream = new HttpClientOutputStream(printWriter);

                InfoProcessor requestProcessor = new RequestProcessor();

                Thread userThread = new Thread(new HandleUserThread(userInputStream, userOutputStream, requestProcessor));
                userThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            chatServer.close();
        }
    }
}
