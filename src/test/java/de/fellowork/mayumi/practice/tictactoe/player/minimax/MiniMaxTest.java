package de.fellowork.mayumi.practice.tictactoe.player.minimax;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;

import de.fellowork.mayumi.practice.tictactoe.player.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
import static org.mockito.Mockito.*;

class MiniMaxTest {

    private TicTacToeBoard board;
    private GameStateEvaluator evaluator;
    private Player ki;
    private Player opponent;
    private MiniMaxImpl miniMax;


    @BeforeEach
    void setUp() {

        board = mock(TicTacToeBoard.class);
        evaluator = mock(GameStateEvaluator.class);
        ki = mock(Player.class);
        opponent = mock(Player.class);
        miniMax = new MiniMaxImpl(evaluator, board, ki, opponent);

    }


    @Test
    void minimaxTestIsMaximizingPlayerHasNotWon(){

        when(evaluator.checkPLayerWinningStatus(ki, board)).thenReturn(false);
        when(board.boardIsFull()).thenReturn(false);

        miniMax.minimax(true,9);

        InOrder checkOrder = inOrder(evaluator, board);

        checkOrder.verify(evaluator).checkPLayerWinningStatus(ki,board);
        checkOrder.verify(board).boardIsFull();



    }

    @Test
    void minimaxTestIsMaximizingPlayerHasWon(){

        when(evaluator.checkPLayerWinningStatus(ki, board)).thenReturn(true);
//        miniMax.maximize()


    }

    @Test
    void minimaxTestIsMinimizingPlayer(){


    }

}
