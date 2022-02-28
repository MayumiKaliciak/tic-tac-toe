package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.input.DefaultInputCollector;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.*;
import de.fellowork.mayumi.practice.tictactoe.player.*;
import de.fellowork.mayumi.practice.tictactoe.player.minimax.MinimaxFactory;

import java.util.Optional;
import java.util.Scanner;

/**
 * baut das spiel zusammen und startet es
 */
public class TicTacToe {

    public Optional<Player> startGame(TicTacToeInputCollector collector) {
        TicTacToePrinterFactory printerFactory = new TicTacToePrinterFactory(new ConsoleOutput());
        TicTacToePrinter printer = printerFactory.createPrinter();

        GameStateEvaluator evaluator = new GameStateEvaluator();
        PlayerConfigurator configurator = new PlayerConfigurator(printer, collector, new MinimaxFactory(evaluator));
        PlayerConfiguration configuration = configurator.createConfiguration();

        TicTacToeGameLoop loop = new TicTacToeGameLoop(printer, evaluator);
        return loop.run(new TicTacToeBoard(), configuration);
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);
        TicTacToeInputCollector inputCollector = new DefaultInputCollector(scanner);

        startGame(inputCollector);
    }
}
