package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KIPlayer implements Player {

    private final String playerSymbol;

    private final TicTacToeInputCollector collector;

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        //MinMax

        return board;
    }

    @Override
    public String getPlayerSymbol() {
        return playerSymbol;
    }
}
