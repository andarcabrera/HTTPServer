package CobSpecApp.Parsers;

import CobSpecApp.Parsers.RangeParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/9/16.
 */
public class RangeParserTest {
    private RangeParser parser;

    @Before
    public void setup() throws Exception{
        parser = new RangeParser();
    }

    @Test
    public void testGetRangeBothLimitsProvided(){
        assertEquals(5, parser.containerSize("bytes=0-4", 10));
        assertEquals(0, parser.getSkipedBytes());
        assertEquals(35, parser.containerSize("bytes=10-44", 50));
        assertEquals(10, parser.getSkipedBytes());
        assertEquals(35, parser.containerSize(" bytes=10-44", 50));
        assertEquals(35, parser.containerSize(" bytes=10-44 ", 50));
    }

    @Test
    public void testGetRangeStartingRangeProvidedOnly(){
        assertEquals(6, parser.containerSize("bytes=4-", 10));
        assertEquals(4, parser.getSkipedBytes());
        assertEquals(10, parser.containerSize("bytes=10- ", 20));
        assertEquals(10, parser.getSkipedBytes());
    }

    @Test
    public void testGetRangeBytesFromEndOFileProvided(){
        assertEquals(6, parser.containerSize("bytes=-6", 10));
        assertEquals(4, parser.getSkipedBytes());
        assertEquals(11, parser.containerSize("bytes=-11 ", 20));
        assertEquals(9, parser.getSkipedBytes());
    }
}