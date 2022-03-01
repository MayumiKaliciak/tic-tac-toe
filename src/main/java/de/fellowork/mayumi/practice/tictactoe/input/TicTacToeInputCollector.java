package de.fellowork.mayumi.practice.tictactoe.input;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;

import java.util.Optional;

public interface TicTacToeInputCollector {
    GameModeKey collectPlayerType();

    Optional<TicTacToeFieldKey> collectGameMove();
}
