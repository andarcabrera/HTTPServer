package FileMgmt;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/1/16.
 */
public class AccessFileTest {
    private AccessFile accessFile;

    @Before
    public void setup() throws Exception{
        accessFile = new AccessFile();
    }

    @Test
    public void testReadFromFile() throws Exception {
        String testFile = "./src/test/java/resources/testFile";
        assertEquals("Busted!", new String(accessFile.readFromFile(testFile)));
    }
}