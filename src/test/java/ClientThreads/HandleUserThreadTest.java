package ClientThreads;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HandleUserThreadTest {
    MockRequestProcessor requestProcessor = new MockRequestProcessor();
    MockInputStream input = new MockInputStream();
    MockOutputStream output = new MockOutputStream();
    HandleUserThread userThread;

    @Before
    public void setup(){
        userThread = new HandleUserThread(input, output, requestProcessor);
    }


    @Test
    public void testRunOneLine() throws Exception {
        input.addInput("Hello World");
        Thread thread = new Thread(userThread);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Hello World", output.revealOutputStream());
    }

    @Test
    public void testRunTwoLines() throws Exception {
        input.addInput("Hello World");
        input.addInput("I love thread join!");
        Thread thread = new Thread(userThread);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertEquals("Hello WorldI love thread join!", output.revealOutputStream());
    }
}