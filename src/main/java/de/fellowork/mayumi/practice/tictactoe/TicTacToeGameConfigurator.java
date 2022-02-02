package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

import java.util.Scanner;

/**
 * wer spielt gegen wen? (h-ki,hu-hu,ki-ki)? start: hu-hu, hu-ki erfordert nur anpassung in config impl
 *
 *
 * welcher spieler beginnt
 */

@AllArgsConstructor
public class TicTacToeGameConfigurator {

    private static final String PLAYER_SYMBOL_X = "x";
    private static final String PLAYER_SYMBOL_O = "o";

    private final TicTacToePrinter printer;
    private final TicTacToeInputCollector collector;
    private final TicTacToeBoard board;

    public GameConfiguration createConfiguration(){

        printer.printGameConfiguration();

        printer.printChoosePlayerOne();
        Player playerOne = getPlayer(PLAYER_SYMBOL_X);

        printer.printChoosePlayerTwo();
        Player playerTwo = getPlayer(PLAYER_SYMBOL_O);

        return new GameConfiguration(playerOne, playerTwo);
    }

    private Player getPlayer(String playerSymbol) {

        Player createdPlayer = null;

        while(createdPlayer == null) {

            String selectedPlayerType = collector.collectPlayerType();

            if("human".equals(selectedPlayerType)){
                createdPlayer = new HumanPlayer(playerSymbol, printer, collector, board);

            } else if ("computer".equals(selectedPlayerType)){
                createdPlayer = new KIPlayer(playerSymbol, collector);

            } else {
                printer.printFailureMessage();
            }
        }
        return createdPlayer;
    }

}
