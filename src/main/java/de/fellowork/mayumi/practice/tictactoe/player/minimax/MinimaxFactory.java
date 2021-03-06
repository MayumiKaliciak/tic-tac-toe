package de.fellowork.mayumi.practice.tictactoe.player.minimax;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import lombok.RequiredArgsConstructor;

import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;

@RequiredArgsConstructor
public class MinimaxFactory {

    private final GameStateEvaluator evaluator;

    public MiniMax buildMiniMax(Player player, TicTacToeBoard board) {

        if(PLAYER_SYMBOL_X.equals(player.getPlayerSymbol())) {
            return new MiniMaxImpl(evaluator, board, player, new MiniMaxPlayer(PLAYER_SYMBOL_O));
        } else {
            return new MiniMaxImpl(evaluator, board, player, new MiniMaxPlayer(PLAYER_SYMBOL_X));
        }


    }
}
