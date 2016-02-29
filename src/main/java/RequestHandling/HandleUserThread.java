package RequestHandling;

import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;
import Request.InfoProcessor;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class HandleUserThread implements Runnable{
    private HttpInputStream input;
    private HttpOutputStream output;
    private InfoProcessor requestProcessor;

    public HandleUserThread(HttpInputStream inputStream, HttpOutputStream outputStream, InfoProcessor requestProcessor) {
        this.input = inputStream;
        this.output = outputStream;
        this.requestProcessor = requestProcessor;
    }

    private String readRequest() {
        String request= input.readMessage();
        return request;
    }

    private void writeMessage(String message) {
        output.writeMessage(message);
    }


    public void run() {
        System.out.println(Thread.currentThread().getName() + "connected to server");

        String requestLine;
        StringBuffer rawRequest = new StringBuffer();

        while (((requestLine = readRequest())) != null) {
            System.out.println(requestLine);
            rawRequest.append(requestLine + "\n");
            if (requestLine.isEmpty()) {
                break;
            }
        }
            requestProcessor.handleRequest(rawRequest);
            String response = requestProcessor.response();
            if (response != null) {
                System.out.println(Thread.currentThread().getName() + "response");
                System.out.println(response);
                writeMessage(response);
            }
        System.out.println("Out of the loop");
    }
}
