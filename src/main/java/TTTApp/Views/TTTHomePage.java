package TTTApp.Views;

/**
 * Created by andacabrera29 on 3/23/16.
 */
public class TTTHomePage implements View {
    @Override
    public byte[] generateHtml(int size, String[] markers, String[] board) {
        return new byte[0];
    }

    public byte[] homePageHtml(){
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
        htmlContent.append("<div class=\"board-size-container\">\n");
        htmlContent.append("<h3 class=\"board-size-selection\">Chose your adventure. May the force of minimax be with you!</h3>\n");
        htmlContent.append("<form action=\"/games\" method= \"post\">\n");
        htmlContent.append("<div id=\"board-size\">\n");
        htmlContent.append("<h4 id=\"board-size-title\">Board size:</h4>\n");
        htmlContent.append("<span class=\"board-size-details\">\n");
        htmlContent.append("<input type=\"radio\" name=\"size\" id=\"9\" value=\"9\" checked>\n");
        htmlContent.append("<label for=\"9\">3X3</label>\n");
        htmlContent.append("<input type=\"radio\" name=\"size\" id=\"16\" value=\"16\">");
        htmlContent.append("<label for=\"16\">4X4</label>");
        htmlContent.append("</span>");
        htmlContent.append("</div>");
        htmlContent.append("<div class=\"player-details\">");
        htmlContent.append("<h4 class=\"form-title\">Player 1:</h4>");
        htmlContent.append("<input type=\"radio\" name=\"player1_type\" id=\"player1_human\" value=\"human\" checked>");
        htmlContent.append("<label for=\"player1_human\">Human</label><br>");
        htmlContent.append("<input type=\"radio\" name=\"player1_type\" id=\"player1_computer\" value=\"computer\">");
        htmlContent.append("<label for=\"player1_computer\" name=\"player1_type\">Computer  </label><br>");
        htmlContent.append("<label for=\"player1_marker\" name=\"player1_marker\">Marker   </label>");
        htmlContent.append("<input type=\"text\" name=\"player1_marker\" id=\"player1_marker\" value=\"X\" required=\"true\"><br>");
        htmlContent.append("<label for=\"player1_name\" name=\"player1_name\">Name   </label>");
        htmlContent.append("<input type=\"text\" name=\"player1_name\" id=\"player1_name\" value=\"Player1\" required=\"true\">");
        htmlContent.append("</div>");
        htmlContent.append("<div class=\"player-details\">");
        htmlContent.append("<h4 class=\"form-title\">Player 2:</h4>");
        htmlContent.append("<input type=\"radio\" name=\"player2_type\" id=\"player2_human\" value=\"human\" checked>");
        htmlContent.append("<label for=\"player2_human\">Human</label><br>");
        htmlContent.append("<input type=\"radio\" name=\"player2_type\" id=\"player2_computer\" value=\"computer\">");
        htmlContent.append("<label for=\"player2_computer\">Computer  </label><br>");
        htmlContent.append("<label for=\"player2_marker\" name=\"player2_marker\">Marker   </label>");
        htmlContent.append("<input type=\"text\" name=\"player2_marker\" id=\"player2_marker\" value=\"Y\" required=\"true\"><br>");
        htmlContent.append("<label for=\"player2_name\" name=\"player2_name\">Name   </label>");
        htmlContent.append("<input type=\"text\" name=\"player2_name\" id=\"player2_name\" value=\"Player2\" required=\"true\">");
        htmlContent.append("<br>");
        htmlContent.append("</div>");
        htmlContent.append("<div class=\"submit-button\">");
        htmlContent.append("<input type=\"submit\" value=\"Submit\">");
        htmlContent.append("</div>");
        htmlContent.append("</form>");
        htmlContent.append("</div>");
        htmlContent.append("</body>\n");
        htmlContent.append("</html>\n");

        return htmlContent.toString().getBytes();

    }
}




















