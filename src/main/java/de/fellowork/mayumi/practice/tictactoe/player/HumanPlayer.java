package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
class HumanPlayer implements Player {

    private final PlayerSymbol playerSymbol;
    private final TicTacToePrinter printer;
    private final TicTacToeInputCollector collector;

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        Optional<TicTacToeFieldKey> currentGameMove = collector.collectGameMove();

        if(currentGameMove.isPresent()){
            TicTacToeFieldKey key = currentGameMove.get();
            if(!board.hasPlayerSet(key)){
                board.setPlayer(key, this);
                return board;
            }
        }
        printer.invalidGameFieldKeyEntered();
        return doGameMove(board);

    }

    @Override
    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }
}
