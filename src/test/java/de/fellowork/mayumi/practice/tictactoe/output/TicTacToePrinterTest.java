package de.fellowork.mayumi.practice.tictactoe.output;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.output.ConsoleOutput;
import de.fellowork.mayumi.practice.tictactoe.output.EnglishMessages;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import org.junit.jupiter.api.Test;

/**
 * TODO: Assert console output later
 */
class TicTacToePrinterTest {

    private final TicTacToePrinter printer = new TicTacToePrinter(new ConsoleOutput(), new EnglishMessages());

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