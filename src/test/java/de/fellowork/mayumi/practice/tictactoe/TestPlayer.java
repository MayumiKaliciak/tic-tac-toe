package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol;

public class TestPlayer implements Player {
    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {
        return board;
    }

    @Override
    public PlayerSymbol getPlayerSymbol() {
        return PlayerSymbol.PLAYER_SYMBOL_X;
    }
}
