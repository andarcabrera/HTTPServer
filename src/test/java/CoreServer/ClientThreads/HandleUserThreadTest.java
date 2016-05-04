package CoreServer.ClientThreads;

import CoreServer.Request.InfoProcessor;
import CoreServer.Router.MockRouter;
import CoreServer.Router.RouterStrategy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandleUserThreadTest {
    private InfoProcessor requestProcessor;
    private MockInputStream input;
    private MockOutputStream output;
    private RouterStrategy router;
    private HandleUserThread userThread;

    @Before
    public void setup(){
        requestProcessor = new MockRequestProcessor();
        input = new MockInputStream();
        output = new MockOutputStream();
        router = new MockRouter();
        userThread = new HandleUserThread(input, output, requestProcessor, router);
    }

    @Test
    public void testRunNoBody() throws Exception {
        input.addInput("method~GET  url~/action");
        userThread.run();

        assertEquals("null", output.revealOutputStream());

    }

    @Test
    public void testRunWithBody() throws Exception {
        input.addInput("method~GET  url~/action  rawBody~ThisIsTheBodyOfTheMockResponse");
        userThread.run();

        assertEquals("ThisIsTheBodyOfTheMockResponse", output.revealOutputStream());
    }
}