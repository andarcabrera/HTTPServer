package Controllers;

import Helpers.CookieParser;
import Helpers.GameInfoParser;
import Request.RequestBuilder;
import Response.ResponseBuilder;
import TTT.GameRuby;
import Views.*;

import java.util.Map;

public class TTTController extends Controller{
    AbstractViewFactory viewFactory;
    private View index;
    private View gameOverView;
    private View makeMoveView;
    private GameInfoParser gameInfoParser = new GameInfoParser();
    private CookieParser cookieParser = new CookieParser();

    public TTTController(RequestBuilder request, ResponseBuilder response, AbstractViewFactory viewFactory){
        super(request, response);
        this.viewFactory = viewFactory;
        this.index = viewFactory.createHomePageView();
        this.gameOverView = viewFactory.createGameOverView();
        this.makeMoveView = viewFactory.createMakeMoveView();
    }

    public ResponseBuilder get(RequestBuilder request) {
        response.setStatusCode("OK");
        response.setResponseBody(index.homePageHtml());
        return response;
    }

    public ResponseBuilder post(RequestBuilder request) {
        Map<String, String> params = gameInfoParser.getParams(request.getRawBody());

        GameRuby rubyGame = new GameRuby();
        rubyGame.setGame(params, null);
        rubyGame.play();

        String[] board = rubyGame.getBoard();
        String[] markers = rubyGame.getMarkers();
        int size = rubyGame.getSize();
        boolean gameOver = rubyGame.gameOver();

        if (gameOver){
            response.addHeader("Set-Cookie", "game_info=: ");
            gameOver(size, markers, board);
        } else {
            response.addHeader("Set-Cookie", "game_info=:" + request.getRawBody());
            makeMove(size, markers, board);
        }
        return response;
    }

    public ResponseBuilder put(RequestBuilder request) {
        String spot = gameInfoParser.getSpot(request.getUrl());
        Map<String, String> cookie = cookieParser.getCookieInfo(request.getHeaders().get("Cookie"));
        String parsedCookie = cookie.get("game_info");
        Map<String, String> params = gameInfoParser.getParams(parsedCookie);

        GameRuby rubyGame = new GameRuby();
        rubyGame.setGame(params, spot);

        int size = rubyGame.getSize();
        String[] filled_spots = cookieParser.getBoardState(size);
        rubyGame.updateBoard(filled_spots);
        rubyGame.play();

        String[] board = rubyGame.getBoard();
        String[] markers = rubyGame.getMarkers();
        boolean gameOver = rubyGame.gameOver();
        String stringBoard = getStringBoard(board);

        if (gameOver){
            response.addHeader("Set-Cookie", "board=: ");
            gameOver(size, markers, board);
        } else {
            response.addHeader("Set-Cookie", "board=:" + stringBoard);
            makeMove(size, markers, board);
        }
        return response;
    }

    private String getStringBoard(String[] board){
        String extractedBoard = "";
        for (int i = 0; i < board.length; i++){
            extractedBoard += board[i] + "-";
        }
        return  extractedBoard;
    }

    private void makeMove(int size, String[] markers, String[] board){
        response.setStatusCode("OK");
        response.setResponseBody(makeMoveView.generateHtml(size, markers, board));
    }

    private void gameOver(int size, String[] markers, String[] board){
        response.setStatusCode("OK");
        response.setResponseBody(gameOverView.generateHtml(size, markers, board));
    }
}
