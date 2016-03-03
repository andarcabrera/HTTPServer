package Views;

import org.junit.Before;
import org.junit.Test;

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
        directoryName = "./src/test/java/resources";
        File directory = new File(String.valueOf(ClassLoader.getSystemResource(directoryName)));
        files = directory.listFiles();
    }

    @Test
    public void testHtmlBody() throws Exception {
        assertEquals(expectedHtmlContent(), new String(htmlContent.htmlBody(files, directoryName)));
    }

    private String expectedHtmlContent(){
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> Anda's HTML Server</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "<ul>\n" +
                "<li><a href=\"/testFile\">/testFile</a></li>" +
                "<li><a href=\"/testFile2\">/testFile2</a></li>" +
                "<li><a href=\"/testFile3\">/testFile3</a></li>" +
                "</ul>" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }
}