package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.player.minimax.MiniMax;
import de.fellowork.mayumi.practice.tictactoe.player.minimax.MinimaxFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class KIPlayer implements Player {

    private final PlayerSymbol playerSymbol;
    private final MinimaxFactory minimaxFactory;

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        int bestScore = Integer.MIN_VALUE;
        TicTacToeFieldKey bestField = null;

        for (TicTacToeFieldKey fieldKey : board.getKeysOfFreeFields()) {

            MiniMax miniMax = createMiniMax(board, fieldKey);

            int score = miniMax.calculateScore();
            if (score > bestScore) {
                bestScore = score;
                bestField = fieldKey;
            }
        }

        if (bestScore != Integer.MIN_VALUE) {
            board.setPlayer(bestField, this);
        }
        return board;
    }

    private MiniMax createMiniMax(TicTacToeBoard board, TicTacToeFieldKey fieldKey) {
        TicTacToeBoard copyBoard = board.clone();
        copyBoard.setPlayer(fieldKey, this);
        return minimaxFactory.buildMiniMax(this, copyBoard);
    }

    @Override
    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }

}