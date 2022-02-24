package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import lombok.AllArgsConstructor;

import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;

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

            String selectedPlayerType = collector.collectPlayerType();

            if ("1".equals(selectedPlayerType)) {
                Player playerOne = new HumanPlayer(PLAYER_SYMBOL_X, printer, collector);
                Player playerTwo = new HumanPlayer(PLAYER_SYMBOL_O, printer, collector);
                return new PlayerConfiguration(playerOne, playerTwo);

            } else if ("2".equals(selectedPlayerType)) {
                Player playerOne = new HumanPlayer(PLAYER_SYMBOL_X, printer, collector);
                Player playerTwo = new KIPlayer(PLAYER_SYMBOL_O, minimaxFactory);
                return new PlayerConfiguration(playerOne, playerTwo);

            } else if ("3".equals(selectedPlayerType)) {
                Player playerOne = new KIPlayer(PLAYER_SYMBOL_X, minimaxFactory);
                Player playerTwo = new KIPlayer(PLAYER_SYMBOL_O, minimaxFactory);
                return new PlayerConfiguration(playerOne, playerTwo);

            } else {
                printer.printFailureMessage();
            }
        }
    }

}
