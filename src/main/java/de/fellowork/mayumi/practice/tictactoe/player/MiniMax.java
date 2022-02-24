package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MiniMax {

    private final GameStateEvaluator evaluator;
    private final Player ki;
    private final Player opponent;

    public int minimax(boolean isMaximizingPlayer, TicTacToeBoard copyBoard) {
        return minimax(isMaximizingPlayer, 9, copyBoard);
    }

    public int minimax(boolean isMaximizingPlayer, int depth, TicTacToeBoard copyBoard) {

        if (evaluator.checkPLayerWinningStatus(isMaximizingPlayer ? ki : opponent, copyBoard)) {
            return evaluate(isMaximizingPlayer);
        }

        if (copyBoard.boardIsFull()) {
            return 0;
        }

        if (isMaximizingPlayer) {
            return maximize(depth, copyBoard);
        } else {
            return minimize(depth, copyBoard);
        }

    }

    private int maximize(int depth, TicTacToeBoard copyBoard) {

        int bestScore = Integer.MIN_VALUE;

        for (TicTacToeFieldKey fieldKey : copyBoard.getKeysOfFreeFields()) {
            copyBoard.setPlayer(fieldKey, ki);
            int score = minimax(false, depth - 1, copyBoard);
            copyBoard.unsetPlayer(fieldKey, ki);
            bestScore = Integer.max(bestScore, score);
        }

        return bestScore;
    }

    private int minimize(int depth, TicTacToeBoard copyBoard) {

        int bestScore = Integer.MAX_VALUE;

        for (TicTacToeFieldKey fieldKey : copyBoard.getKeysOfFreeFields()) {

            copyBoard.setPlayer(fieldKey, opponent);
            int score = minimax(true, depth - 1, copyBoard);
            copyBoard.unsetPlayer(fieldKey, opponent);
            bestScore = Integer.min(bestScore, score);
        }

        return bestScore;
    }

    private int evaluate(boolean isMaximizingPlayer) {
        if (isMaximizingPlayer) {
            return 10;
        } else {
            return -10;
        }
    }
}
