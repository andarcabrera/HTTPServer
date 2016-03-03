package Server;

import IOStreams.HttpClientInputStream;
import IOStreams.HttpClientOutputStream;
import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;
import Request.InfoProcessor;
import Request.RequestProcessor;
import ClientThreads.HandleUserThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class HTTPServer {
    public void listen() throws IOException {
        ServerSocket chatServer = new ServerSocket(5000);

        try {
            while (true) {
                Socket userSocket = chatServer.accept();

                DataOutputStream dataOutputStream = new DataOutputStream(userSocket.getOutputStream());
                BufferedReader inputReader = new BufferedReader(new InputStreamReader(userSocket.getInputStream()));

                HttpInputStream userInputStream = new HttpClientInputStream(inputReader);
                HttpOutputStream userOutputStream = new HttpClientOutputStream(dataOutputStream);

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
