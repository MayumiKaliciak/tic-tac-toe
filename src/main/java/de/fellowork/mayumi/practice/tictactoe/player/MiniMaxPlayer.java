package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;

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
