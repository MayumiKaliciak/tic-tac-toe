package de.fellowork.mayumi.practice.tictactoe;

/**
 *
 * baut das spiel zusammen und startet es
 */
public class TicTacToe {

    public void startGame() {

        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToePrinter printer = new TicTacToePrinter();
        TicTacToeGameConfigurator configurator = new TicTacToeGameConfigurator();
        GameConfiguration configuration = configurator.createConfiguration();
        GameStateEvaluator evaluator = new GameStateEvaluator();
        TicTacToeGameLoop loop = new TicTacToeGameLoop(printer, configuration, evaluator);


        loop.run(board,1);


    }
}
