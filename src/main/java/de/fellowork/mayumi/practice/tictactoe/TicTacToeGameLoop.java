package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicTacToeGameLoop {

    private final TicTacToePrinter printer;
    private final GameConfiguration configuration;
    private final GameStateEvaluator evaluator;
    private final Player playerOne = configuration.getPlayerOne();
    private final Player playerTwo = configuration.getPlayerTwo();


    public void run(TicTacToeBoard board, int gameRound) {


        printer.printStartPlayInfo();

        if (!evaluator.gameIsOver(board)) {
            alternateGameMoves(board, gameRound);
        } else {
            lookForResult();
        }
    }

    private void alternateGameMoves(TicTacToeBoard board, int gameRound) {


        if (gameRound <= 9) {
            if (gameRound % 2 != 0) {
                board = playerOne.doGameMove(board);
            } else {
                board = playerTwo.doGameMove(board);
            }
            gameRound++;
            alternateGameMoves(board, gameRound + 1);
        }

        //TODO braucht es hier einen break? oder geht er aus dem if einfach raus, sobald gameRound > 9 ist?
    }

    private void lookForResult() {
        if (evaluator.playerOneWon()) {
            printer.printPlayerOneWon();
        } else if (evaluator.playerTwoWon()) {
            printer.printPlayerTwoWon();
        } else {
            printer.printOutDraw();
        }
    }

}

