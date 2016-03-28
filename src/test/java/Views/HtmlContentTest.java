package Views;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;

import static org.junit.Assert.assertEquals;

/**
 * Created by andacabrera29 on 3/2/16.
 */
public class HtmlContentTest {
    private HtmlContent htmlContent;
    private String directoryName;
    File[] files;

    @Before
    public void setup(){
        htmlContent = new HtmlContent();
    }

    @Rule
    public TemporaryFolder folder= new TemporaryFolder();


    @Test
    public void testHtmlBody() throws Exception {
        File createdFile= folder.newFile("testFile1");
        File createdFile1= folder.newFile("testFile2");
        File createdFile2= folder.newFile("testFile3");
        File folderRoot = folder.getRoot();
        String folderPath = folderRoot.getPath();
        File[] files = folderRoot.listFiles();


        assertEquals(expectedHtmlContent(), new String(htmlContent.htmlBody(files, folderPath)));
    }

    private String expectedHtmlContent(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> Anda's HTML Server</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "<h2> <a href=\"/ttt\"> Play TTT </a> </h2> \n" +
                "<ul>\n" +
                "<li><a href=\"/testFile1\">/testFile1</a></li>" +
                "<li><a href=\"/testFile2\">/testFile2</a></li>" +
                "<li><a href=\"/testFile3\">/testFile3</a></li>" +
                "</ul>" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }
}





