package de.fellowork.mayumi.practice.tictactoe.input;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;

import java.util.Optional;

public interface TicTacToeInputCollector {
    String collectPlayerType();

    Optional<TicTacToeFieldKey> collectGameMove();
}
