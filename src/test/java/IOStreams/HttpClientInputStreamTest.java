package IOStreams;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;

import static org.junit.Assert.assertEquals;


/**
 * Created by andacabrera29 on 3/9/16.
 */
public class HttpClientInputStreamTest {
    private  BufferedReader testBuffer = null;


    @Test
    public void testReadMessage() throws Exception {
        byte[] testByteArray= "Test".getBytes();
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(testByteArray);
        testBuffer = new BufferedReader(new InputStreamReader(testInputStream));
        HttpClientInputStream httpInputStream = new HttpClientInputStream(testBuffer);

        assertEquals("T", httpInputStream.readMessage());
        assertEquals("e", httpInputStream.readMessage());
        assertEquals("s", httpInputStream.readMessage());
        assertEquals("t", httpInputStream.readMessage());
    }

    @Test
    public void testReady() throws Exception {
        byte[] testByteArray= "K".getBytes();
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(testByteArray);
        testBuffer = new BufferedReader(new InputStreamReader(testInputStream));
        HttpClientInputStream httpInputStream = new HttpClientInputStream(testBuffer);

        assertEquals(true, httpInputStream.ready());
        assertEquals("K", httpInputStream.readMessage());
        assertEquals(false, httpInputStream.ready());
    }
}