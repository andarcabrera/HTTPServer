package Views;

import java.io.File;

/**
 * Created by andacabrera29 on 3/2/16.
 */
public class HtmlContent {
    public byte[] htmlBody(File[] files, String sourceDirectory){
       String htmlDoc=  "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> Anda's HTML Server</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                generateFileLinks(files, sourceDirectory) +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        return htmlDoc.getBytes();
    }

    private String generateFileLinks(File[] files, String sourceDirectory){
        String fileBullets = "<ul>\n";
        for (File file : files){
            fileBullets += "<li><a href=\"";
            fileBullets += trimFilePath(file.toString(), sourceDirectory) + "\">";
            fileBullets += trimFilePath(file.toString(), sourceDirectory);
            fileBullets += "</a></li>";
        }
        fileBullets += "</ul>";
        return fileBullets;
    }

    private String trimFilePath(String fullPath, String sourceDirectory){
        return fullPath.substring(sourceDirectory.length(), fullPath.length());
    }
}




