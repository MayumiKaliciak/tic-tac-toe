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

        printer.printGameMoveRequest();
        collector.collectGameMove();

        if(board.setPlayer(fieldKey, board)){
            printer.printBoardToConsole(board);
        }


        return board;
    }

    @Override
    public String getPlayerSymbol() {
        return playerSymbol;
    }
}
