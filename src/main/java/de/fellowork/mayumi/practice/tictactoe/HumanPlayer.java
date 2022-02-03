package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HumanPlayer implements Player {


    private final String playerSymbol;
    private final TicTacToePrinter printer;
    private final TicTacToeInputCollector collector;
    private final TicTacToeBoard board;

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
    public String getPlayerSymbol() {
        return playerSymbol;
    }
}
