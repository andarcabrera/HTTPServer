package CobSpecApp.Views;

import java.io.File;

/**
 * Created by andacabrera29 on 3/2/16.
 */
public class HtmlContent {
    public byte[] htmlBody(File[] files, String sourceDirectory){
       String htmlDoc=  "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> Anda's HTML CoreServer.Server</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "<h2> <a href=\"/ttt\"> Play TTTApp.TTT </a> </h2> \n" +
                generateFileLinks(files, sourceDirectory) +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        return htmlDoc.getBytes();
    }

    public byte[] formHtml(String field1){
        String htmlDoc=  "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title> Anda's HTML CoreServer.Server</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                formField(field1) +
                "</div>\n" +
                "</body>\n" +
                "</html>";
        return htmlDoc.getBytes();
    }

    private String formField(String field1){
        StringBuilder form = new StringBuilder();
        form.append("<form action=\\form method=\"post\">");
        form.append("Submit " + field1);
        form.append(": <br>");
        form.append("<input type=\"text\" name=\"");
        form.append(field1);
        form.append("\"><br>");
        form.append("<input type=\"submit\" value=\"Submit\">");
        form.append("</form>");
        form.append("<br>");

        form.append("<form action=\\form method=\"post\">");
        form.append("<input type=\"hidden\" value=\"DELETE\" />");
        form.append("<input type=\"submit\" value=\"Delete\">");
        form.append("</form>");

        form.append("<br><br>");

        return form.toString();
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




