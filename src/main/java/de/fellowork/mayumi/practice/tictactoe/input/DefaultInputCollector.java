package de.fellowork.mayumi.practice.tictactoe.input;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import lombok.RequiredArgsConstructor;

import java.util.Optional;
import java.util.Scanner;

@RequiredArgsConstructor
public class DefaultInputCollector implements TicTacToeInputCollector {

    private final Scanner scanner;

    @Override
    public String collectPlayerType() {
        return scanner.nextLine();
    }

    @Override
    public Optional<TicTacToeFieldKey> collectGameMove() {
        String scannedLine = scanner.nextLine();
        return TicTacToeFieldKey.findByNumberString(scannedLine);
    }
}
