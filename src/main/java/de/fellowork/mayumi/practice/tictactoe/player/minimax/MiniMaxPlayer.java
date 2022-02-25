package de.fellowork.mayumi.practice.tictactoe.player.minimax;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol;

class MiniMaxPlayer implements Player {

    private final PlayerSymbol playerSymbol;

    MiniMaxPlayer(PlayerSymbol playerSymbol) {
        this.playerSymbol = playerSymbol;
    }

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {
        return board;
    }

    @Override
    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }
}
