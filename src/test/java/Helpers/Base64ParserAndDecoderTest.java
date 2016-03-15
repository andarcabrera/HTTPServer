package Helpers;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/14/16.
 */
public class Base64ParserAndDecoderTest {
    private Base64ParserAndDecoder decoder;

    @Before
    public void setUp(){
        decoder = new Base64ParserAndDecoder();
        decoder.decodeBase64(" Basic YWRtaW46aHVudGVyMg== ");
    }

    @Test
    public void testDecode() throws Exception {
        assertEquals("admin", decoder.getUser());
        assertEquals("hunter2", decoder.getPassword());
    }
}