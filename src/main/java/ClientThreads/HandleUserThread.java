package ClientThreads;

import Helpers.RequestLogger;
import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;
import Request.InfoProcessor;
import Request.RequestBuilder;
import Router.RouterStrategy;

import java.util.logging.Level;

/**
 * Created by andacabrera29 on 2/24/16.
 */
public class HandleUserThread implements Runnable{
    private HttpInputStream input;
    private HttpOutputStream output;
    private InfoProcessor requestProcessor;
    private RouterStrategy router;

    public HandleUserThread(HttpInputStream inputStream, HttpOutputStream outputStream, InfoProcessor requestProcessor, RouterStrategy router) {
        this.input =  inputStream;
        this.output = outputStream;
        this.requestProcessor = requestProcessor;
        this.router = router;
    }

    private String readRequest() {
        return input.readMessage();
    }

    private void writeMessage(byte[] message) {
        output.writeMessage(message);
    }


    public void run() {
        StringBuffer rawRequest = new StringBuffer();
        String requestChar;

        while (input.ready() || rawRequest.length() < 5) {
            requestChar = readRequest();
            rawRequest.append(requestChar);
        }

        RequestLogger.logger.log(Level.INFO, rawRequest.toString());

        requestProcessor.handleRequest(rawRequest);
        RequestBuilder request = requestProcessor.getRequest();
        router.route(request);

        byte[] response = router.getResponse();
        RequestLogger.logger.log(Level.INFO, response.toString());
        writeMessage(response);
    }
}
