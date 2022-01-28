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
    public void run(TicTacToeBoard board) {
        configuration.getPlayerOne();
        configuration.getPlayerTwo();

    }
}
