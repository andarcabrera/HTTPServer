package FileMgmt;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by andacabrera29 on 3/2/16.
 */
public class AccessDirectoryTest {
    AccessDirectory accessDirectory;

    @Before
    public void setup() throws Exception{
        accessDirectory = new AccessDirectory();
    }

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();

    @Test
    public void testUsingTempFolder() throws IOException {
        File createdFile= folder.newFile("testFile1");
        File createdFile1= folder.newFile("testFile2");
        File createdFile2= folder.newFile("testFile3");
        File folderRoot = folder.getRoot();
        String folderPath = folderRoot.getPath();

        assertEquals(3, accessDirectory.getFiles(folderPath).length);
        assertTrue(accessDirectory.getFiles(folderPath)[0].getPath().contains("testFile1"));
    }
}



