package TTTApp.Controllers;

import CoreServer.Controllers.Controller;
import TTTApp.Parsers.CookieParser;
import TTTApp.Parsers.GameInfoParser;
import CoreServer.Request.Request;
import CoreServer.Response.Response;
import TTTApp.TTTGame.TTTGame;
import TTTApp.Views.AbstractViewFactory;
import TTTApp.Views.View;

import java.util.Map;

public class TTTController extends Controller {
    AbstractViewFactory viewFactory;
    private View index;
    private View gameOverView;
    private View makeMoveView;
    private GameInfoParser gameInfoParser = new GameInfoParser();
    private CookieParser cookieParser = new CookieParser();
    private TTTGame rubyGame;

    public TTTController(Request request, Response response, String methodsAllowed, AbstractViewFactory viewFactory, GameInfoParser gameInfoParser, CookieParser cookieParser, TTTGame game){
        super(request, response, methodsAllowed);
        this.viewFactory = viewFactory;
        this.index = viewFactory.createHomePageView();
        this.gameOverView = viewFactory.createGameOverView();
        this.makeMoveView = viewFactory.createMakeMoveView();
        this.gameInfoParser =gameInfoParser;
        this.cookieParser = cookieParser;
        this.rubyGame = game;
    }

    public Response tttHomePage() {
        response.setStatusCode("OK");
        response.setResponseBody(index.homePageHtml());
        return response;
    }

    public Response startGame() {
        Map<String, String> params = gameInfoParser.getParsedInfo(request.getRawBody());

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

    public Response makeMove() {
        String spot = getSpot(request.getUrl());
        Map<String, String> cookie = cookieParser.getParsedInfo(request.getHeaders().get("Cookie"));
        String parsedCookie = cookie.get("game_info");
        Map<String, String> params = gameInfoParser.getParsedInfo(parsedCookie);
        rubyGame.setGame(params, spot);

        int size = rubyGame.getSize();
        String[] filled_spots = getBoardState(size, cookie);
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

    private void makeMove(int size, String[] markers, String[] board){
        response.setStatusCode("OK");
        response.setResponseBody(makeMoveView.generateHtml(size, markers, board));
    }

    private void gameOver(int size, String[] markers, String[] board){
        response.setStatusCode("OK");
        response.setResponseBody(gameOverView.generateHtml(size, markers, board));
    }

    private String getStringBoard(String[] board){
        String extractedBoard = "";
        for (int i = 0; i < board.length; i++){
            extractedBoard += board[i] + "-";
        }
        return  extractedBoard;
    }

    private String getSpot(String action){
        String[] splitActionLine = action.split("/");
        return splitActionLine[2].trim();
    }

    private String[] getBoardState(int size, Map<String, String> cookie){
        String cookieBoard = cookie.get("board");
        String[] boardState = new String[size];
        if (cookieBoard == null){
            for (int i = 0; i < size ;i++){
                boardState[i] = String.valueOf(i);
            }
        }else {
            boardState = cookieBoard.split("-");
        }
        return boardState;
    }
}
