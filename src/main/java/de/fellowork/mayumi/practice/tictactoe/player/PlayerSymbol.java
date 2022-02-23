package de.fellowork.mayumi.practice.tictactoe.player;

import lombok.Getter;

public enum PlayerSymbol {
    PLAYER_SYMBOL_X("x"),
    PLAYER_SYMBOL_O("o");


    @Getter
    private final String symbolAsString;

    PlayerSymbol(String symbolAsString) {
        this.symbolAsString = symbolAsString;
    }

}
