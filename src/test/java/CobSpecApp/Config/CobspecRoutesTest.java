package CobSpecApp.Config;

import CoreServer.FileMgmt.AccessDirectory;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by andacabrera29 on 5/4/16.
 */
public class CobspecRoutesTest {
    private CobspecRoutes cobspecRoutes;
    private AccessDirectory accessDirectory;

    @Before
    public void setUp() {
        accessDirectory = new AccessDirectory();
    }

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();


    @Test
    public void testGetRoutes() throws Exception {
        File createdFile= folder.newFile("testFile1");
        File createdFile1= folder.newFile("testFile2");
        File createdFile2= folder.newFile("testFile3");
        File folderRoot = folder.getRoot();
        String folderPath = folderRoot.getPath();
        cobspecRoutes = new CobspecRoutes(folderPath);

        assertEquals("GET /testFile1", cobspecRoutes.getRoutes().get(0).getRequestAction());
        assertEquals("GET /testFile2", cobspecRoutes.getRoutes().get(1).getRequestAction());
        assertEquals("GET /testFile3", cobspecRoutes.getRoutes().get(2).getRequestAction());
        assertEquals("GET /", cobspecRoutes.getRoutes().get(3).getRequestAction());
    }
}