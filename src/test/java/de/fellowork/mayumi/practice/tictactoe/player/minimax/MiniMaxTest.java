package de.fellowork.mayumi.practice.tictactoe.player.minimax;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.player.Player;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.One;
import static org.assertj.core.api.Assertions.in;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

class MiniMaxTest {

    private TicTacToeBoard board;
    private GameStateEvaluator evaluator;
    private Player ki;
    private Player opponent;
    private MiniMaxImpl miniMax;
    private MiniMaxImpl miniMaxMock;


    @BeforeEach
    void setUp() {

        board = mock(TicTacToeBoard.class);
        evaluator = mock(GameStateEvaluator.class);
        ki = mock(Player.class);
        opponent = mock(Player.class);
        miniMax = new MiniMaxImpl(evaluator, board, ki, opponent);
        miniMaxMock = mock(MiniMaxImpl.class);

    }


    @Test
    void minimaxTestIsMaximizingPlayer(){

        testMiniMax(true, 10, ki);

    }

    @Test
    void minimaxTestIsMinimizingPlayer(){
        testMiniMax(false, -10, opponent);

    }

    private void testMiniMax(boolean isMaximizingPlayer, int expectedScore, Player player) {
        List<TicTacToeFieldKey> listOfFreeKeys = new ArrayList<>();
        listOfFreeKeys.add(One);

        when(evaluator.checkPlayerWinningStatus(player, board)).thenReturn(false, true);
        when(board.boardIsFull()).thenReturn(false);
        when(board.getKeysOfFreeFields()).thenReturn(listOfFreeKeys);


        int score = miniMax.minimax(isMaximizingPlayer, 9);
        assertThat(score).isEqualTo(expectedScore);

        InOrder checkOrder = inOrder(evaluator, board, miniMaxMock);

        checkOrder.verify(evaluator).checkPlayerWinningStatus(player,board);
        checkOrder.verify(board).boardIsFull();
        checkOrder.verify(board).getKeysOfFreeFields();
        checkOrder.verify(board).setPlayer(One, player);
        checkOrder.verify(evaluator).checkPlayerWinningStatus(player, board);
        checkOrder.verify(board).unsetPlayer(One, player);
    }



    @Test
    void boardFull(){

        when(evaluator.checkPlayerWinningStatus(opponent, board)).thenReturn(false, true);
        when(board.boardIsFull()).thenReturn(true);

        int score = miniMax.calculateScore();
        assertThat(score).isEqualTo(0);

        InOrder checkOrder = inOrder(evaluator, board);

        checkOrder.verify(evaluator).checkPlayerWinningStatus(opponent, board);
        checkOrder.verify(board).boardIsFull();
        verifyNoMoreInteractions(evaluator, board);


    }

}
