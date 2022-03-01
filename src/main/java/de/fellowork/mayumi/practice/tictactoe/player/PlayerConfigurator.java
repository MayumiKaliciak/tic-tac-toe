package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.input.GameModeKey;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import de.fellowork.mayumi.practice.tictactoe.player.minimax.MinimaxFactory;
import lombok.AllArgsConstructor;

import java.util.concurrent.Executors;

import static de.fellowork.mayumi.practice.tictactoe.input.GameModeKey.*;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
import static java.util.concurrent.Executors.*;

/**
 * wer spielt gegen wen? (h-ki,hu-hu,ki-ki)? start: hu-hu, hu-ki erfordert nur anpassung in config impl
 * <p>
 * <p>
 * welcher spieler beginnt
 */

@AllArgsConstructor
public class PlayerConfigurator {

    private final TicTacToePrinter printer;
    private final TicTacToeInputCollector collector;
    private final MinimaxFactory minimaxFactory;

    public PlayerConfiguration createConfiguration() {

        printer.printGameConfiguration();
        printer.printChoosePlayerOption();

        while (true) {

            GameModeKey gameMode = collector.collectPlayerType();

            if (HumanHuman.equals(gameMode)) {
                Player playerOne = new HumanPlayer(PLAYER_SYMBOL_X, printer, collector);
                Player playerTwo = new HumanPlayer(PLAYER_SYMBOL_O, printer, collector);
                return new PlayerConfiguration(playerOne, playerTwo);

            } else if (HumanComputer.equals(gameMode)) {
                Player playerOne = new HumanPlayer(PLAYER_SYMBOL_X, printer, collector);
                Player playerTwo = new KIPlayer(PLAYER_SYMBOL_O, minimaxFactory,  newFixedThreadPool(8));
                return new PlayerConfiguration(playerOne, playerTwo);

            } else if (ComputerComputer.equals(gameMode)) {
                Player playerOne = new KIPlayer(PLAYER_SYMBOL_X, minimaxFactory,  newFixedThreadPool(9));
                Player playerTwo = new KIPlayer(PLAYER_SYMBOL_O, minimaxFactory,  newFixedThreadPool(9));
                return new PlayerConfiguration(playerOne, playerTwo);

            } else {
                printer.printFailureMessage();
            }
        }
    }

}
