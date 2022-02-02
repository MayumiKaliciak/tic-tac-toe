package de.fellowork.mayumi.practice.tictactoe;

/**
 *
 * baut das spiel zusammen und startet es
 */
public class TicTacToe {

    public void startGame() {

        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToePrinter printer = new TicTacToePrinter();
        TicTacToeInputCollector collector = new TicTacToeInputCollector();
        TicTacToeGameConfigurator configurator = new TicTacToeGameConfigurator(printer, collector, board);
        GameConfiguration configuration = configurator.createConfiguration();
        GameStateEvaluator evaluator = new GameStateEvaluator(board);

        TicTacToeGameLoop loop = new TicTacToeGameLoop(printer, configuration, evaluator);


        loop.run(board,1);


    }
}
