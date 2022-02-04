package de.fellowork.mayumi.practice.tictactoe;

public class TestPlayer implements Player {
    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {
        return board;
    }

    @Override
    public String getPlayerSymbol() {
        return "X";
    }
}
