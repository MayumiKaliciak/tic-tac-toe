package de.fellowork.mayumi.practice.tictactoe.input;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;

import java.util.Scanner;

public class DefaultInputCollector implements TicTacToeInputCollector {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String collectPlayerType() {
        return scanner.nextLine();
    }

    @Override
    public TicTacToeFieldKey collectGameMove() {
        String scannedLine = scanner.nextLine();
        return TicTacToeFieldKey.findByNumberString(scannedLine).orElse(null);
    }
}
