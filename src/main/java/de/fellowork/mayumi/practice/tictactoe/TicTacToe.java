package de.fellowork.mayumi.practice.tictactoe;

/**
 *
 * baut das spiel zusammen und startet es
 */
public class TicTacToe {

    public void startGame() {


        TicTacToePrinter printer = new TicTacToePrinter();
        TicTacToeInputCollector collector = new TicTacToeInputCollector();
        GameStateEvaluator evaluator = new GameStateEvaluator();
        TicTacToeGameConfigurator configurator = new TicTacToeGameConfigurator(printer, collector, evaluator);
        GameConfiguration configuration = configurator.createConfiguration();

        TicTacToeGameLoop loop = new TicTacToeGameLoop(printer, evaluator);

        loop.run(new TicTacToeBoard(),configuration);


    }
}
