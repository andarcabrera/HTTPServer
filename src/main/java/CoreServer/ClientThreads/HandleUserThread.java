package CoreServer.ClientThreads;

import CobSpecApp.Config.RequestLogger;
import CoreServer.IOStreams.HttpInputStream;
import CoreServer.IOStreams.HttpOutputStream;
import CoreServer.Request.InfoProcessor;
import CoreServer.Request.Request;
import CoreServer.Router.RouterStrategy;

import java.lang.reflect.InvocationTargetException;
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

    public void run() {
        int requestChar;
        StringBuffer rawRequest = new StringBuffer();

        while ((requestChar = input.read()) != -1){
            rawRequest.append((char) requestChar);
            if (!input.ready()) break;
        }

        RequestLogger.logger.log(Level.INFO, rawRequest.toString());

        requestProcessor.handleRequest(rawRequest);
        Request request = requestProcessor.getRequest();

        router.route(request);
        byte[] response = new byte[0];
        try {
            response = router.getResponse();
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        writeMessage(response);
    }

    private void writeMessage(byte[] message) {
        output.writeMessage(message);
    }
}