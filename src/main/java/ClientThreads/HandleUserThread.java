package ClientThreads;

import Helpers.RequestLogger;
import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;
import Request.InfoProcessor;

import java.util.logging.Level;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class HandleUserThread implements Runnable{
    private HttpInputStream input;
    private HttpOutputStream output;
    private InfoProcessor requestProcessor;
    private String directory;


    public HandleUserThread(HttpInputStream inputStream, HttpOutputStream outputStream, InfoProcessor requestProcessor) {
        this.input =  inputStream;
        this.output = outputStream;
        this.requestProcessor = requestProcessor;
    }

    private String readRequest() {
        return input.readMessage();
    }

    private void writeMessage(byte[] message) {
        output.writeMessage(message);
    }


    public void run() {
//        System.out.println(Thread.currentThread().getName() + "connected to server");

        StringBuffer rawRequest = new StringBuffer();
        String requestChar;

        while (input.ready() || rawRequest.length() < 1) {
            requestChar = readRequest();
            rawRequest.append(requestChar);
        }

//        System.out.println("rawRequest" + rawRequest.toString());

        RequestLogger.logger.log(Level.INFO, rawRequest.toString());

        requestProcessor.handleRequest(rawRequest);

        byte[] response = requestProcessor.response();
//            System.out.println(Thread.currentThread().getName() + "response:");
//            System.out.println(new String(response));
        writeMessage(response);
    }
}
