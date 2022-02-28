package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import lombok.AllArgsConstructor;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.*;

@AllArgsConstructor
public class GameStateEvaluator {

    public boolean checkPlayerWinningStatus(Player player, TicTacToeBoard board) {
        return sameValuesInColumn(player, board) ||
                sameValuesInRow(player, board) ||
                sameValuesInDiagonal(player, board);
    }

    public boolean sameValuesInColumn(Player player, TicTacToeBoard board) {
        return firstColumnWins(player, board) ||
                secondColumnWins(player, board) ||
                thirdColumnWins(player, board);
    }

    public boolean sameValuesInRow(Player player, TicTacToeBoard board) {
        return firstRowWins(player, board) ||
                secondRowWins(player, board) ||
                thirdRowWins(player, board);
    }

    public boolean sameValuesInDiagonal(Player player, TicTacToeBoard board) {
        return topLeftToBottomRightWins(player, board) ||
                bottomLeftToTopRightWins(player, board);
    }


    private boolean thirdColumnWins(Player player, TicTacToeBoard board) {
        return board.isPLayerOnField(Nine, player) && board.isPLayerOnField(Six, player) && board.isPLayerOnField(Three, player);
    }

    private boolean secondColumnWins(Player player, TicTacToeBoard board) {
        return board.isPLayerOnField(Eight, player) && board.isPLayerOnField(Five, player) && board.isPLayerOnField(Two, player);
    }

    private boolean firstColumnWins(Player player, TicTacToeBoard board) {
        return board.isPLayerOnField(Seven, player) && board.isPLayerOnField(Four, player) && board.isPLayerOnField(One, player);
    }

    private boolean thirdRowWins(Player player, TicTacToeBoard board) {
        return board.isPLayerOnField(One, player) && board.isPLayerOnField(Two, player) && board.isPLayerOnField(Three, player);
    }

    private boolean secondRowWins(Player player, TicTacToeBoard board) {
        return board.isPLayerOnField(Four, player) && board.isPLayerOnField(Five, player) && board.isPLayerOnField(Six, player);
    }

    private boolean firstRowWins(Player player, TicTacToeBoard board) {
        return board.isPLayerOnField(Seven, player) && board.isPLayerOnField(Eight, player) && board.isPLayerOnField(Nine, player);
    }

    private boolean bottomLeftToTopRightWins(Player player, TicTacToeBoard board) {
        return board.isPLayerOnField(One, player) && board.isPLayerOnField(Five, player) && board.isPLayerOnField(Nine, player);
    }

    private boolean topLeftToBottomRightWins(Player player, TicTacToeBoard board) {
        return board.isPLayerOnField(Seven, player) && board.isPLayerOnField(Five, player) && board.isPLayerOnField(Three, player);
    }

}
