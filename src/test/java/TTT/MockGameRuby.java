package TTT;

import java.util.Map;

/**
 * Created by andacabrera29 on 4/1/16.
 */
public class MockGameRuby implements TTTGame {
    private String[] markers;
    private int size;
    private String[] board;
    private String gameOver;


    public MockGameRuby(Map<String, String[]> mockData){
        this.size = Integer.parseInt(mockData.get("size")[0]);
        this.gameOver = mockData.get("gameOver")[0];
        this.markers = mockData.get("markers");
        this.board = mockData.get("board");
    }

    @Override
    public String[] getMarkers() {
        return markers;
    }

    @Override
    public void play() {

    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String[] getBoard() {
        return board;
    }

    @Override
    public boolean gameOver() {
        if (gameOver.equals("true")){
            return true;
        }else return false;
    }

    @Override
    public void updateBoard(String[] currentState) {

    }

    @Override
    public void setGame(Map<String, String> requestParams, String spot) {

    }
}
