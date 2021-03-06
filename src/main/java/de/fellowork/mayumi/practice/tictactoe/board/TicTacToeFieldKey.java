package de.fellowork.mayumi.practice.tictactoe.board;

import de.fellowork.mayumi.practice.tictactoe.input.GameModeKey;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public enum TicTacToeFieldKey {

    One("1"),
    Two("2"),
    Three("3"),
    Four("4"),
    Five("5"),
    Six("6"),
    Seven("7"),
    Eight("8"),
    Nine("9");

    @Getter
    private final String numberAsString;

    TicTacToeFieldKey(String numberAsString) {
        this.numberAsString = numberAsString;
    }

    public static List<TicTacToeFieldKey> toList() {
        return Arrays.asList(values());
    }

    public static Optional<TicTacToeFieldKey> findByNumberString(String numberAsString) {
        return toList().stream()
                .filter(filterByNumber(numberAsString))
                .findFirst();
    }

    private static Predicate<TicTacToeFieldKey> filterByNumber(String numberAsString) {
        return key -> key.getNumberAsString().equals(numberAsString);
    }

}
