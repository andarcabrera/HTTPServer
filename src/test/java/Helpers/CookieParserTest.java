package Helpers;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

/**
 * Created by andacabrera29 on 3/30/16.
 */
public class CookieParserTest {
    private CookieParser parser;
    private HashMap<String, String> testParams;

    @Before
    public void setUp(){
        parser = new CookieParser();
        testParams = new HashMap<>();
        testParams.put("game_info", "size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2");
    }

    @Test
    public void testGetGameInfo() throws Exception {
        assertEquals(testParams, parser.getParsedInfo("textwrapon=false; wysiwyg=textarea; game_info=:size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2"));
    }

    @Test
    public void testGetGameInfoSpots() throws Exception {
        assertEquals("spots1", parser.getParsedInfo("textwrapon=false; wysiwyg=textarea; filled_spots=:spots1; game_info=:size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2").get("filled_spots"));
    }

//    @Test
//    public void testGetFilledSpots() throws Exception {
//        String[] testSpots = new String[] {"0", "X", "Y", "3", "4", "5", "6", "7", "8"};
//        parser.getParsedInfo("board=:0-X-Y-3-4-5-6-7-8; textwrapon=false; wysiwyg=textarea; game_info=:size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2");
//
//         assertEquals(testSpots, parser.getBoardState(9));
//    }
//
//    @Test
//    public void testGetFilledSpotsNoState() throws Exception {
//        String[] testSpots = new String[] {"0", "1", "2", "3", "4", "5", "6", "7", "8"};
//        parser.getParsedInfo("textwrapon=false; wysiwyg=textarea; game_info=:size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2");
//
//         assertEquals(testSpots, parser.getBoardState(9));
//    }
//
//    @Test
//    public void testGetFilledSpots4X4board() throws Exception {
//        String[] testSpots = new String[] {"0", "X", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "Y", "13", "14", "15"};
//        parser.getParsedInfo("textwrapon=false; board=:0-X-2-3-4-5-6-7-8-9-10-11-Y-13-14-15; wysiwyg=textarea; game_info=:size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2");
//
//         assertEquals(testSpots, parser.getBoardState(16));
//    }


}