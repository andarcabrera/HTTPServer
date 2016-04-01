package Helpers;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/23/16.
 */
public class GameInfoParserTest {
    private GameInfoParser parser;
    private HashMap<String, String> testParams;

    @Before
    public void setUp(){
        parser = new GameInfoParser();
        testParams = new HashMap<>();
        testParams.put("size", "9");
        testParams.put("player1_type", "human");
        testParams.put("player1_marker", "X");
        testParams.put("player1_name", "Player1");
        testParams.put("player2_type", "human");
        testParams.put("player2_marker", "Y");
        testParams.put("player2_name", "Player2");
    }

    @Test
    public void testGetParams(){
        assertEquals(testParams, parser.getParsedInfo("size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2"));
    }

}