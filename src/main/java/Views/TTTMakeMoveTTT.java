package Views;

/**
 * Created by andacabrera29 on 3/28/16.
 */
public class TTTMakeMoveTTT {
    public byte[] generateHtml(int size, String[] markers, String[] board ){
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n");
        htmlContent.append("<html lang=\"en\">");
        htmlContent.append("<head>\n");
        htmlContent.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://rawgit.com/andarcabrera/sinatra_ttt/master/public/css/application.css\">\n");
        htmlContent.append("<title> Anda's Java Server with TTT </title>\n");
        htmlContent.append("</head>\n");
        htmlContent.append("<br>\n");
        htmlContent.append("<body>\n");
        htmlContent.append("<h1 class=\"ttt-title\">TicTacToe</h1>\n");
        htmlContent.append("<div class=\"ttt-board\">\n");
        htmlContent.append("<table>");

        int rows = (int) Math.sqrt(size);
        for (int i = 0; i < size; i+= rows){
            htmlContent.append("<tr>\n");
            for (int j=0; j<rows; j++){
                htmlContent.append("<td class=\"board-cell\" id=\"" + String.valueOf(i+j) + "\">\n");
                String spot = board[i + j];
                System.out.println(spot);
                if (markers[0].equals(spot) || markers[1].equals(spot)){
                    htmlContent.append(spot);
                } else {
                    htmlContent.append("<form action=\"make_move/");
                    htmlContent.append(String.valueOf(i+j) + "\" method=\"post\">");
                    htmlContent.append("<input type=\"submit\" class=\"spot-link\">");
                    htmlContent.append("</form");
                }
                htmlContent.append("</td>");
            }
            htmlContent.append("</tr>");
        }

        htmlContent.append("</table>");
        htmlContent.append("</div>");
        htmlContent.append("<h3 id=\"game-over\">Click to make your move</h3>\n");
        htmlContent.append("<div id=\"home-button\">\n");
        htmlContent.append("<form action=\"/games\">\n");
        htmlContent.append("<input type=\"submit\" value=\"Home\">\n");
        htmlContent.append("</form>\n");
        htmlContent.append("</div>");
        htmlContent.append("</body>\n");
        htmlContent.append("</html>\n");

        return htmlContent.toString().getBytes();

    }
}
