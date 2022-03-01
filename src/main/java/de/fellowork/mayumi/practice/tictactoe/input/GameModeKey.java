package de.fellowork.mayumi.practice.tictactoe.input;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public enum GameModeKey {

    Undefined("0"),
    HumanHuman("1"),
    HumanComputer("2"),
    ComputerComputer("3");


    @Getter
    private final String numberAsString;

    GameModeKey(String numberAsString) {
        this.numberAsString = numberAsString;
    }

    public static GameModeKey findByNumberString(String numberAsString) {
        return Arrays.stream(values())
                .filter(filterByNumber(numberAsString))
                .findFirst()
                .orElse(Undefined);
    }

    private static Predicate<GameModeKey> filterByNumber(String numberAsString) {
        return key -> key.getNumberAsString().equals(numberAsString);
    }

}
