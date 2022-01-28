package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicTacToeGameLoop {

    private final TicTacToePrinter printer;
    private final GameConfiguration configuration;
    private final GameStateEvaluator evaluator;

    /**
     * gesamter ablauf /technik des spiels, aber ohne allzu detailierte logik
     *
     * @param board
     */
    public void run(TicTacToeBoard board, int gameRound) {
        Player playerOne = configuration.getPlayerOne();
        Player playerTwo = configuration.getPlayerTwo();

        // print startboard


        if (!evaluator.gameIsOver(board)) {
            if(gameRound % 2 != 0) {
                board = playerOne.doGameMove(board);
            } else {
                board = playerTwo.doGameMove(board);

            }
            // print move

            run(board, gameRound + 1);
        }

        // print result

    }

}
