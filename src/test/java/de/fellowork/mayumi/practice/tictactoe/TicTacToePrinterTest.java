package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import org.junit.jupiter.api.Test;

/**
 * TODO: Assert console output later
 */
class TicTacToePrinterTest {

    private final TicTacToePrinter printer = new TicTacToePrinter();

    @Test
    void printOutDefaultBoard() {
        TicTacToeBoard board = new TicTacToeBoard();
        printer.printBoardToConsole(board);
    }

    @Test
    void printGameStart() {
        printer.printStartPlayInfo();
    }
}