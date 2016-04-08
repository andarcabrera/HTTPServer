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

        assertEquals(httpInputStream.ready(), true);
        assertEquals("T", String.valueOf((char) httpInputStream.read()));
        assertEquals("e", String.valueOf((char) httpInputStream.read()));
        assertEquals("s", String.valueOf((char) httpInputStream.read()));
        assertEquals("t", String.valueOf((char) httpInputStream.read()));
        assertEquals(false, httpInputStream.ready());
    }

    @Test
    public void testReady() throws Exception {
        byte[] testByteArray= "K".getBytes();
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(testByteArray);
        testBuffer = new BufferedReader(new InputStreamReader(testInputStream));
        HttpClientInputStream httpInputStream = new HttpClientInputStream(testBuffer);

        assertEquals(true, httpInputStream.ready());
        assertEquals("K", String.valueOf((char)(httpInputStream.read())));
        assertEquals(false, httpInputStream.ready());
    }

    @Test
    public void testEmptyBuffer() throws Exception {
        byte[] testByteArray= new byte[0];
        ByteArrayInputStream testInputStream = new ByteArrayInputStream(testByteArray);
        testBuffer = new BufferedReader(new InputStreamReader(testInputStream));
        HttpClientInputStream httpInputStream = new HttpClientInputStream(testBuffer);

        assertEquals(false, httpInputStream.ready());
    }
}