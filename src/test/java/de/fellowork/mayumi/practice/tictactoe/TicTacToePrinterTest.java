package de.fellowork.mayumi.practice.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToePrinterTest {

    private final TicTacToePrinter ticTacToePrinter = new TicTacToePrinter();

    @Test
    void printOutDefaultBoard() {
        ticTacToePrinter.printOutDefaultBoard(new TicTacToeBoard());
    }
}