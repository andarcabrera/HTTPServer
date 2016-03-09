package FileMgmt;
//
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
//
//
///**
// * Created by andacabrera29 on 3/2/16.
// */
//public class AccessDirectoryTest {
//    AccessDirectory accessDirectory;
//
//    @Before
//    public void setup() throws Exception{
//        accessDirectory = new AccessDirectory();
//    }
//
//    @Test
//    public void testGetFiles() throws Exception {
//        String directoryAddress = "./src/test/java/resources";
//        assertEquals(3, accessDirectory.getFiles(directoryAddress).length);
//        assertEquals("./src/test/java/resources/testFile", accessDirectory.getFiles(directoryAddress)[0].toString());
//        assertEquals("./src/test/java/resources/testFile3", accessDirectory.getFiles(directoryAddress)[2].toString());
//    }
//}