package TTTApp.TTTGame;

import java.util.Map;

/**
 * Created by andacabrera29 on 4/1/16.
 */
public interface TTTGame {
    String[] getMarkers();
    void play();
    int getSize();
    String[] getBoard();
    boolean gameOver();
    void updateBoard(String[] currentState);
    void setGame(Map<String, String> requestParams, String spot);

}
