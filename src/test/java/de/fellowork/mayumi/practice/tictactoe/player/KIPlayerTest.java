package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.One;
import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.Two;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.*;

class KIPlayerTest {

    private TicTacToeBoard board;
    private TicTacToeBoard copyBoard;
    private MiniMax miniMax;
    private MinimaxFactory minimaxFactory;

    private Player playerOne;


    @BeforeEach
    void setUp() {

        board = mock(TicTacToeBoard.class);
        miniMax = mock(MiniMax.class);
        minimaxFactory = mock(MinimaxFactory.class);
        playerOne = new KIPlayer(PLAYER_SYMBOL_X, minimaxFactory);

        when(minimaxFactory.buildMiniMax(playerOne)).thenReturn(miniMax);
    }

    @Test
    void currentScoreIsBetterThanBestScore() {

        List<TicTacToeFieldKey> listOfFreeKeys = new ArrayList<>();
        listOfFreeKeys.add(One);

        when(board.clone()).thenReturn(board);

        when(board.getKeysOfFreeFields()).thenReturn(listOfFreeKeys);
        when(miniMax.minimax(false, board)).thenReturn(-10);

        playerOne.doGameMove(board);

        InOrder checkOrder = inOrder(board, minimaxFactory, miniMax);

        checkOrder.verify(board).getKeysOfFreeFields();
        checkOrder.verify(board).setPlayer(One, playerOne);
        checkOrder.verify(minimaxFactory).buildMiniMax(playerOne);
        checkOrder.verify(miniMax).minimax(false, board);
        checkOrder.verify(board).unsetPlayer(One, playerOne);
        checkOrder.verify(board).setPlayer(One,playerOne);

    }

    @Test
    void currentScoreNotBetterThanBestScore() {

        List<TicTacToeFieldKey> listOfFreeKeys = new ArrayList<>();
        listOfFreeKeys.add(One);

        when(board.clone()).thenReturn(board);

        when(board.getKeysOfFreeFields()).thenReturn(listOfFreeKeys);
        when(miniMax.minimax(false, board)).thenReturn(Integer.MIN_VALUE);

        playerOne.doGameMove(board);

        InOrder checkOrder = inOrder(board, minimaxFactory, miniMax);

        checkOrder.verify(board).getKeysOfFreeFields();
        checkOrder.verify(board).setPlayer(One, playerOne);
        checkOrder.verify(minimaxFactory).buildMiniMax(playerOne);
        checkOrder.verify(miniMax).minimax(false, board);
        checkOrder.verify(board).unsetPlayer(One, playerOne);
        checkOrder.verify(board, never()).setPlayer(One, playerOne);

    }


}