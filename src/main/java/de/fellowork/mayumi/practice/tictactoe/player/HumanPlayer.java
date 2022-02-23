package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
class HumanPlayer implements Player {

    private final PlayerSymbol playerSymbol;
    private final TicTacToePrinter printer;
    private final TicTacToeInputCollector collector;

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        // make pretty
        TicTacToeFieldKey currentKey = null;
        while(currentKey == null){
            currentKey = collector.collectGameMove();
            if(currentKey == null){
                printer.invalidGameFieldKeyEntered();
            }
        }
        board.setPlayer(currentKey, this);

        return board;
    }

    @Override
    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }
}
