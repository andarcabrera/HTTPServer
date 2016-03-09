package Helpers;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

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
        assertArrayEquals(new int[]{0, 5}, parser.getRange("bytes=0-4", 10));
        assertArrayEquals(new int[]{10, 45}, parser.getRange("bytes=10-44", 50));
        assertArrayEquals(new int[]{10, 45}, parser.getRange(" bytes=10-44", 50));
        assertArrayEquals(new int[]{10, 45}, parser.getRange(" bytes=10-44 ", 50));
    }

    @Test
    public void testGetRangeStartingRangeProvidedOnly(){
        assertArrayEquals(new int[]{4, 10}, parser.getRange("bytes=4-", 10));
        assertArrayEquals(new int[]{10, 20}, parser.getRange("bytes=10- ", 20));
    }

    @Test
    public void testGetRangeBytesFromEndOFileProvided(){
        assertArrayEquals(new int[]{4, 10}, parser.getRange("bytes=-6", 10));
        assertArrayEquals(new int[]{9, 20}, parser.getRange("bytes=-11 ", 20));
    }
}