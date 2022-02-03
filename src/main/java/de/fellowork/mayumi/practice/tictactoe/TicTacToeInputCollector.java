package de.fellowork.mayumi.practice.tictactoe;

import java.util.Scanner;

public class TicTacToeInputCollector {

    private final Scanner scanner = new Scanner(System.in);

    public String collectPlayerType() {
        return scanner.nextLine();
    }

    public TicTacToeFieldKey collectGameMove() {
        String scannedLine = scanner.nextLine();
        return TicTacToeFieldKey.findByNumberString(scannedLine).orElse(null);
    }
}
