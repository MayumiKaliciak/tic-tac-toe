package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;

import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;

class KIPlayer implements Player {

    private final PlayerSymbol playerSymbol;
    private final GameStateEvaluator evaluator;
    private final Player tempMiniMaxOpponentDummy;

    KIPlayer(PlayerSymbol playerSymbol, GameStateEvaluator evaluator) {
        this.playerSymbol = playerSymbol;
        this.evaluator = evaluator;

        if (PLAYER_SYMBOL_X.equals(playerSymbol)) {
            tempMiniMaxOpponentDummy = new MiniMaxPlayer(PLAYER_SYMBOL_O);
        } else {
            tempMiniMaxOpponentDummy = new MiniMaxPlayer(PLAYER_SYMBOL_X);
        }
    }

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        TicTacToeBoard copyBoard = board.clone();
        int bestScore = Integer.MIN_VALUE;
        TicTacToeFieldKey bestField = null;
        for (TicTacToeFieldKey fieldKey : copyBoard.getKeysOfFreeFields()) {
            if (!copyBoard.isPLayerOnField(fieldKey, this)) {
                copyBoard.setPlayer(fieldKey, this);
                int score = minimax(false, 9, copyBoard);
                copyBoard.unsetPlayer(fieldKey, this);

                if (score > bestScore) {
                    bestScore = score;
                    bestField = fieldKey;
                }
            }
        }

        if (bestScore != Integer.MIN_VALUE) {
            board.setPlayer(bestField, this);
        }
        return board;
    }

    private int minimax(boolean isMaximizingPlayer, int depth, TicTacToeBoard copyBoard) {

        if (evaluator.checkPLayerWinningStatus(isMaximizingPlayer ? this : tempMiniMaxOpponentDummy, copyBoard)) {
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
            if (!copyBoard.isPLayerOnField(fieldKey, tempMiniMaxOpponentDummy)) {
                copyBoard.setPlayer(fieldKey, tempMiniMaxOpponentDummy);
                int score = minimax(true, hightOfTree - 1, copyBoard);
                copyBoard.unsetPlayer(fieldKey, tempMiniMaxOpponentDummy);
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
    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }

}