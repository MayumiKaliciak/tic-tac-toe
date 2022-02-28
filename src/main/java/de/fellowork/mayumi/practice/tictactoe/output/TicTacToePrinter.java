package de.fellowork.mayumi.practice.tictactoe.output;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class TicTacToePrinter {

    private final ConsoleOutput consoleOutput;
    private final Messages messages;

    public void printLanguageSetting(){
        consoleOutput.printToConsole(messages.getLanguageMessage());
    }

    public void printStartPlayInfo() {
        consoleOutput.printToConsole(messages.getWelcomeMessage());
        String printedTicTacToe = getPrintedTicTacToe();
        consoleOutput.printToConsole(printedTicTacToe);
    }

    public void printGameConfiguration() {
        consoleOutput.printToConsole("The options to play TicTacToe are: \n1: human-human\n2: human-computer\n3: computer-computer");
    }

    public void printChoosePlayerOption() {
        consoleOutput.printToConsole("Please select option for the first player by typing in correct option number");
    }

    public void printFailureMessage() {
        consoleOutput.printToConsole("Not able to recognize input. Please try again choosing 'human' or 'computer'");
    }

    public void printGameMoveRequest() {
        consoleOutput.printToConsole("Please select field");
    }

    public void printBoardToConsole(TicTacToeBoard board) {
        String printedTicTacToe = getPrintedTicTacToe();
        for (TicTacToeFieldKey key : TicTacToeFieldKey.toList()) {
            Player player = board.getPlayer(key);

            if (playerIsSet(player)) {
                printedTicTacToe = putPlayerSymbolIntoBoardToPrint(printedTicTacToe, key, player);
            }

        }
        consoleOutput.printToConsole(printedTicTacToe);
    }

    public boolean playerIsSet(Player player) {
        return player != null;
    }

    private String putPlayerSymbolIntoBoardToPrint(String printedTicTacToe, TicTacToeFieldKey key, Player player) {
        printedTicTacToe = printedTicTacToe.replace(key.getNumberAsString(), player.getPlayerSymbol().getSymbolAsString());
        return printedTicTacToe;
    }

    public void printOutDraw() {
        consoleOutput.printToConsole("Draw! Nobody has won the game");
    }

    public void printPlayerWon(Player player) {
        consoleOutput.printToConsole("The winner is Player: " + player.getPlayerSymbol());
    }

    public void invalidGameFieldKeyEntered() {
        consoleOutput.printToConsole("You entered an invalid field number. Try again.");
    }

    private String getPrintedTicTacToe() {
        return "7 | 8 | 9\n---------\n4 | 5 | 6\n---------\n1 | 2 | 3\n";
    }
}
