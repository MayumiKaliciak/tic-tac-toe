package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;

@RequiredArgsConstructor
public class MinimaxFactory {
    private final GameStateEvaluator evaluator;

    public MiniMax buildMiniMax(Player player) {

        if(PLAYER_SYMBOL_X.equals(player.getPlayerSymbol())) {
            return new MiniMax(evaluator, player, new MiniMaxPlayer(PLAYER_SYMBOL_O));
        } else {
            return new MiniMax(evaluator, player, new MiniMaxPlayer(PLAYER_SYMBOL_X));
        }


    }
}
