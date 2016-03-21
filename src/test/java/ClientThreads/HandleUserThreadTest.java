//package ClientThreads;
//
//import Request.InfoProcessor;
//import Router.MockRouter;
//import Router.RouterStrategy;
//import org.junit.Before;
//import org.junit.Test;
//
//import static org.junit.Assert.assertEquals;
//
//public class HandleUserThreadTest {
//    private InfoProcessor requestProcessor;
//    private MockInputStream input;
//    private MockOutputStream output;
//    private RouterStrategy router;
//    private HandleUserThread userThread;
//
//    @Before
//    public void setup(){
//        requestProcessor = new MockRequestProcessor();
//        input = new MockInputStream();
//        output = new MockOutputStream();
//        router = new MockRouter();
//
//        userThread = new HandleUserThread(input, output, requestProcessor, router);
//    }
//
//
//    @Test
//    public void testRunOneLine() throws Exception {
//        input.addInput("Hello World");
//        Thread thread = new Thread(userThread);
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        assertEquals("Hello World", output.revealOutputStream());
//    }
//
//    @Test
//    public void testRunTwoLines() throws Exception {
//        input.addInput("Hello World");
//        input.addInput("I love thread join!");
//        Thread thread = new Thread(userThread);
//        thread.start();
//        try {
//            thread.join();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        assertEquals("Hello WorldI love thread join!", output.revealOutputStream());
//    }
//}