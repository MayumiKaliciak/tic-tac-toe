package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import lombok.RequiredArgsConstructor;

import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;

@RequiredArgsConstructor
class KIPlayer implements Player {

    private final PlayerSymbol playerSymbol;
    private final MinimaxFactory minimaxFactory;

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        TicTacToeBoard copyBoard = board.clone();
        int bestScore = Integer.MIN_VALUE;
        TicTacToeFieldKey bestField = null;
        for (TicTacToeFieldKey fieldKey : copyBoard.getKeysOfFreeFields()) {
                copyBoard.setPlayer(fieldKey, this);
                MiniMax miniMax = minimaxFactory.buildMiniMax(this);
                int score = miniMax.minimax(false, copyBoard);
                copyBoard.unsetPlayer(fieldKey, this);

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


    @Override
    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }

}