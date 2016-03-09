package IOStreams;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;

import static org.junit.Assert.assertEquals;


/**
 * Created by andacabrera29 on 3/9/16.
 */
public class HttpClientOutputStreamTest {
    private DataOutputStream outputStream;

    @Test
    public void testWriteMessage() throws Exception {
        ByteArrayOutputStream testOutputStream = new ByteArrayOutputStream();
        outputStream = new DataOutputStream(testOutputStream);
        HttpClientOutputStream httpOutputStream = new HttpClientOutputStream(outputStream);

        byte[] message = "I have two, not one, but two cats".getBytes();
        httpOutputStream.writeMessage(message);
        assertEquals(message.length, outputStream.size());
    }
}