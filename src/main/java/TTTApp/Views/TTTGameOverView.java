package TTTApp.Views;

/**
 * Created by andacabrera29 on 3/28/16.
 */
public class TTTGameOverView implements View {
    public byte[] generateHtml(int size, String[] markers, String[] board ){
        StringBuilder htmlContent = new StringBuilder();
        htmlContent.append("<!DOCTYPE html>\n");
        htmlContent.append("<html lang=\"en\">");
        htmlContent.append("<head>\n");
        htmlContent.append("<link rel=\"stylesheet\" type=\"text/css\" href=\"https://rawgit.com/andarcabrera/sinatra_ttt/master/public/css/application.css\">\n");
        htmlContent.append("<title> Anda's Java CoreServer.Server with TTTApp.TTT </title>\n");
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
                if (markers[0].equals(spot) || markers[1].equals(spot)){
                    htmlContent.append(spot);
                }
                htmlContent.append("</td>");
            }
            htmlContent.append("</tr>");
        }

        htmlContent.append("</table>");
        htmlContent.append("</div>");
        htmlContent.append("<h3 id=\"game-over\">Game over</h3>\n");
        htmlContent.append("<div id=\"home-button\">\n");
        htmlContent.append("<form action=\"/games\">\n");
        htmlContent.append("<input type=\"submit\" value=\"Home\">\n");
        htmlContent.append("</form>\n");
        htmlContent.append("</div>");
        htmlContent.append("</body>\n");
        htmlContent.append("</html>\n");

        return htmlContent.toString().getBytes();

    }

    @Override
    public byte[] homePageHtml() {
        return new byte[0];
    }
}
