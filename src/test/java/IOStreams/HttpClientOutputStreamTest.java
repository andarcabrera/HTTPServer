package IOStreams;

import junit.framework.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.builders.NullBuilder;
import org.junit.rules.ExpectedException;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


/**
 * Created by andacabrera29 on 3/9/16.
 */
public class HttpClientOutputStreamTest {
    @Rule
    public ExpectedException thrown= ExpectedException.none();

    @Test
    public void testWriteMessage() throws Exception {
        ByteArrayOutputStream testOutputStream = new ByteArrayOutputStream();
        DataOutputStream outputStream = new DataOutputStream(testOutputStream);
        HttpClientOutputStream httpOutputStream = new HttpClientOutputStream(outputStream);
        assertEquals(0, outputStream.size());

        byte[] message = "I have two, not one, but two cats".getBytes();
        httpOutputStream.writeMessage(message);
        assertEquals(message.length, outputStream.size());
    }
}