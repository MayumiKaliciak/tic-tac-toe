package de.fellowork.mayumi.practice.tictactoe;

import java.util.Scanner;

public class TicTacToeInputCollector {

    private final Scanner scanner = new Scanner(System.in);

    public String collectPlayerType() {
        return scanner.nextLine();
    }

    public String collectGameMove() {
        return scanner.nextLine();
    }
}
