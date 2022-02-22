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
    private final GameStateEvaluator evaluator;

    public GameConfiguration createConfiguration(){

        printer.printGameConfiguration();
        printer.printChoosePlayerOption();

        while(true){

            String selectedPlayerType = collector.collectPlayerType();

            if("1".equals(selectedPlayerType)){
                Player playerOne = new HumanPlayer(PLAYER_SYMBOL_X, printer, collector);
                Player playerTwo = new HumanPlayer(PLAYER_SYMBOL_O, printer, collector);
                return new GameConfiguration(playerOne, playerTwo);

            } else if ("2".equals(selectedPlayerType)){
                Player playerOne = new HumanPlayer(PLAYER_SYMBOL_X, printer, collector);
                Player playerTwo = new KIPlayer(PLAYER_SYMBOL_O,evaluator, playerOne);
                return new GameConfiguration(playerOne, playerTwo);

            } else {
                printer.printFailureMessage();
            }
        }
    }

}
