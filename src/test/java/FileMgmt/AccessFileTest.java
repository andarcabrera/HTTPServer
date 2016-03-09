package FileMgmt;

import org.junit.Before;
import org.junit.Test;

import java.io.File;

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
    public void testWriteToFile() throws Exception {
        File testFile = File.createTempFile("testFile", "txt");
        String filePath = testFile.getPath();
        testFile.deleteOnExit();

        accessFile.writeToFile(filePath, "Testing, testing, hoping Travis will like it");
        assertEquals("Testing, testing, hoping Travis will like it", new String(accessFile.readFromFile(filePath)));
    }


    @Test
    public void testReadPartiallyFromFile() throws Exception {
        File testFile = File.createTempFile("testFile", "txt");
        String filePath = testFile.getPath();
        testFile.deleteOnExit();

        accessFile.writeToFile(filePath, "This test is especially dedicated to Travis");
        assertEquals("This ", new String(accessFile.readPartiallyFromFile(filePath, "bytes=0-4")));
        assertEquals("Travis", new String(accessFile.readPartiallyFromFile(filePath, "bytes=-6")));
        assertEquals(" is especially dedicated to Travis", new String(accessFile.readPartiallyFromFile(filePath, "bytes=9-")));
    }

    @Test
    public void deleteFileContent() throws Exception {
        File testFile = File.createTempFile("testFile", "txt");
        String filePath = testFile.getPath();
        testFile.deleteOnExit();
        accessFile.writeToFile(filePath, "This test is especially dedicated to Travis");
        accessFile.deleteFileContent(filePath);
        assertEquals("", new String(accessFile.readFromFile(filePath)));
    }
}