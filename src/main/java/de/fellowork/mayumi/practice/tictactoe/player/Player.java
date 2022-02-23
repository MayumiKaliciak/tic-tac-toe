package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;

public interface Player {

    TicTacToeBoard doGameMove(TicTacToeBoard board);
    PlayerSymbol getPlayerSymbol();

    default boolean compareSymbols(Player other){
        return getPlayerSymbol().equals(other.getPlayerSymbol());
    }

}
