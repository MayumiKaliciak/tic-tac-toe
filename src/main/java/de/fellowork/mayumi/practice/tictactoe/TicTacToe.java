package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerConfiguration;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerConfigurator;

/**
 *
 * baut das spiel zusammen und startet es
 */
public class TicTacToe {

    public void startGame() {

        TicTacToePrinter printer = new TicTacToePrinter();
        TicTacToeInputCollector collector = new TicTacToeInputCollector();
        GameStateEvaluator evaluator = new GameStateEvaluator();
        PlayerConfigurator configurator = new PlayerConfigurator(printer, collector, evaluator);
        PlayerConfiguration configuration = configurator.createConfiguration();

        TicTacToeGameLoop loop = new TicTacToeGameLoop(printer, evaluator);

        loop.run(new TicTacToeBoard(),configuration);


    }
}
