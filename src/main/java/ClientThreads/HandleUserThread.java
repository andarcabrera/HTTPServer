package ClientThreads;

import IOStreams.HttpInputStream;
import IOStreams.HttpOutputStream;
import Request.InfoProcessor;
import Request.RequestBuilder;
import Router.RouterStrategy;

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

    private void writeMessage(byte[] message) {
        output.writeMessage(message);
    }

    public void run() {
        int requestChar;
        StringBuffer rawRequest = new StringBuffer();

        while ((requestChar = input.read()) != -1){
            rawRequest.append((char) requestChar);
            if (!input.ready()) break;
        }

//        RequestLogger.logger.log(Level.INFO, rawRequest.toString());

        requestProcessor.handleRequest(rawRequest);
        RequestBuilder request = requestProcessor.getRequest();
        router.route(request);

        byte[] response = router.getResponse();
        writeMessage(response);
    }
}