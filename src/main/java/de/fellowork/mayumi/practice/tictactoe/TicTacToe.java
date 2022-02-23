package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.input.DefaultInputCollector;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerConfiguration;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerConfigurator;

import java.util.Optional;

/**
 * baut das spiel zusammen und startet es
 */
public class TicTacToe {

    public Optional<Player> startGame(TicTacToeInputCollector collector) {

        TicTacToePrinter printer = new TicTacToePrinter();
        GameStateEvaluator evaluator = new GameStateEvaluator();
        PlayerConfigurator configurator = new PlayerConfigurator(printer, collector, evaluator);
        PlayerConfiguration configuration = configurator.createConfiguration();

        TicTacToeGameLoop loop = new TicTacToeGameLoop(printer, evaluator);

        return loop.run(new TicTacToeBoard(), configuration);
    }

    public void startGame() {
        startGame(new DefaultInputCollector());
    }
}
