package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MiniMax {

    private final GameStateEvaluator evaluator;
    private final TicTacToeBoard board;
    private final Player ki;
    private final Player opponent;

    public int calculateScore() {
        return minimax(false, 9);
    }

    public int minimax(boolean isMaximizingPlayer, int depth) {

        if (evaluator.checkPLayerWinningStatus(isMaximizingPlayer ? ki : opponent, board)) {
            return evaluate(isMaximizingPlayer);
        }

        if (board.boardIsFull()) {
            return 0;
        }

        if (isMaximizingPlayer) {
            return maximize(depth);
        } else {
            return minimize(depth);
        }

    }

    private int maximize(int depth) {

        int bestScore = Integer.MIN_VALUE;

        for (TicTacToeFieldKey fieldKey : board.getKeysOfFreeFields()) {
            board.setPlayer(fieldKey, ki);
            int score = minimax(false, depth - 1);
            board.unsetPlayer(fieldKey, ki);
            bestScore = Integer.max(bestScore, score);
        }

        return bestScore;
    }

    private int minimize(int depth) {

        int bestScore = Integer.MAX_VALUE;

        for (TicTacToeFieldKey fieldKey : board.getKeysOfFreeFields()) {

            board.setPlayer(fieldKey, opponent);
            int score = minimax(true, depth - 1);
            board.unsetPlayer(fieldKey, opponent);
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
