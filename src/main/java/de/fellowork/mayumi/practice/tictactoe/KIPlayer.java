package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KIPlayer implements Player {

    private final String playerSymbol;
    private final GameStateEvaluator evaluator;
    private final Player opponent;

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        TicTacToeBoard copyBoard = board.clone();
        int bestScore = Integer.MIN_VALUE;
        TicTacToeFieldKey bestField = null;
        for (TicTacToeFieldKey fieldKey : copyBoard.getKeysOfFreeFields()) {
            if (!copyBoard.isPLayerOnField(fieldKey, this)) {
                copyBoard.setPlayer(fieldKey, this);
                int score = minimax(false, 9 ,copyBoard);
                copyBoard.unsetPlayer(fieldKey, this);

                System.out.println("Fieldkey: " + fieldKey+ ", Score:" + score);

                if (score > bestScore) {
                    bestScore = score;
                    bestField = fieldKey;

                    System.out.println("Setting best Score: " + bestScore + " and bestField: " + bestField);
                }
            }
        }

        if (bestScore != Integer.MIN_VALUE) {
            board.setPlayer(bestField, this);
        }
        return board;
    }

    public int minimax(boolean isMaximizingPlayer, int depth, TicTacToeBoard copyBoard) {
        //System.out.println("maximizing player "+isMaximizingPlayer + " Depth: " + depth);
        if (evaluator.checkPLayerWinningStatus(isMaximizingPlayer ? this : opponent, copyBoard)) {
            int evaluate = evaluate(isMaximizingPlayer);
           // System.out.println("Evaluated Score: "+evaluate + " Depth: " + depth);

            return evaluate;
        }

        if (copyBoard.boardIsFull()) {

            //System.out.println("copyBoard Full");

            return 0;
        }

        if (isMaximizingPlayer) {
            return maximize(depth, copyBoard);
        } else {
            return minimize(depth, copyBoard);
        }

    }

    private int maximize(int hightOfTree, TicTacToeBoard copyBoard) {

        int bestScore = Integer.MIN_VALUE;

        for (TicTacToeFieldKey fieldKey : copyBoard.getKeysOfFreeFields()) {
            if (!copyBoard.isPLayerOnField(fieldKey, this)) {
                copyBoard.setPlayer(fieldKey, this);
                int score = minimax(false, hightOfTree - 1, copyBoard);
                copyBoard.unsetPlayer(fieldKey, this);
                bestScore = Integer.max(bestScore, score);
            }
        }

        return bestScore;
    }

    private int minimize(int hightOfTree, TicTacToeBoard copyBoard) {

        int bestScore = Integer.MAX_VALUE;

        for (TicTacToeFieldKey fieldKey : copyBoard.getKeysOfFreeFields()) {
            if (!copyBoard.isPLayerOnField(fieldKey, opponent)) {
                copyBoard.setPlayer(fieldKey, opponent);
                int score = minimax(true, hightOfTree - 1, copyBoard);
                copyBoard.unsetPlayer(fieldKey, opponent);
                bestScore = Integer.min(bestScore, score);
            }
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

    @Override
    public String getPlayerSymbol() {
        return playerSymbol;
    }

}