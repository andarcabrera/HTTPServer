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
        assertEquals(testParams, parser.getCookieInfo("textwrapon=false; wysiwyg=textarea; rack.session=A; game_info=:size=9&player1_type=human&player1_marker=X&player1_name=Player1&player2_type=human&player2_marker=Y&player2_name=Player2"));
    }


}