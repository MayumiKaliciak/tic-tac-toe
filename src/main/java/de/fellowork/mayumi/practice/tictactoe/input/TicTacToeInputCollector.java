package de.fellowork.mayumi.practice.tictactoe.input;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;

public interface TicTacToeInputCollector {
    String collectPlayerType();
    TicTacToeFieldKey collectGameMove();
}
