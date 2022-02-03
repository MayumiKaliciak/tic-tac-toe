package de.fellowork.mayumi.practice.tictactoe;

/**
 * alles zum spielbrett ausgeben oder züge
 * züge ausgeben
 * spielbrett ausgeben
 * gewinner ausgeben
 */
public class TicTacToePrinter {

    public void printStartPlayInfo() {
        System.out.println("Welcome to Tic Tac Toe. To access the fields press right keys on your keyboard. Example: To access field top right, press 9");
        String printedTicTacToe = "7 | 8 | 9\n---------\n4 | 5 | 6\n---------\n1 | 2 | 3\n";
        System.out.println(printedTicTacToe);
    }

    public void printGameConfiguration() {
        System.out.println("The options to play TicTacToe are: \n1: human-human\n2: human-computer\n3: computer-computer");
    }

    public void printChoosePlayerOne() {
        System.out.println("Please select option for the first player by typing in 'human' or 'computer'");
    }

    public void printChoosePlayerTwo() {
        System.out.println("Please select option for the second player by typing in 'human' or 'computer'");
    }

    public void printFailureMessage() {
        System.out.println("Not able to recognize input. Please try again choosing 'human' or 'computer'");
    }

    public void printGameMoveRequest() {
        System.out.println("Please select field");
    }

    public void printBoardToConsole(TicTacToeBoard board) {
        String printedTicTacToe = "7 | 8 | 9\n---------\n4 | 5 | 6\n---------\n1 | 2 | 3\n";
        for (TicTacToeFieldKey key : TicTacToeFieldKey.toList()) {
            Player player = board.getPlayer(key);

            if (playerIsSet(player)) {
                printedTicTacToe = putPlayerSymbolIntoBoardToPrint(printedTicTacToe, key, player);
            }

        }
        System.out.println(printedTicTacToe);
    }

    public boolean playerIsSet(Player player) {
        return player != null;
    }

    private String putPlayerSymbolIntoBoardToPrint(String printedTicTacToe, TicTacToeFieldKey key, Player player) {
        printedTicTacToe = printedTicTacToe.replace(key.getNumberAsString(), player.getPlayerSymbol());
        return printedTicTacToe;
    }

    public void printOutDraw() {
        System.out.println("Draw! Nobody has won the game");
    }

    public void printPlayerWon(Player player) {
        System.out.println("The winner is Player: " + player.getPlayerSymbol());
    }
}
