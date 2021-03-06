package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.player.minimax.MiniMax;
import de.fellowork.mayumi.practice.tictactoe.player.minimax.MinimaxFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.One;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
import static java.util.concurrent.Executors.*;
import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.*;

class KIPlayerTest {

    private TicTacToeBoard board;
    private MiniMax miniMax;
    private Player playerOne;


    @BeforeEach
    void setUp() {

        board = mock(TicTacToeBoard.class);
        miniMax = mock(MiniMax.class);
        MinimaxFactory minimaxFactory = mock(MinimaxFactory.class);
        playerOne = new KIPlayer(PLAYER_SYMBOL_X, minimaxFactory, newSingleThreadExecutor());

        when(minimaxFactory.buildMiniMax(playerOne, board)).thenReturn(miniMax);
    }

    @Test
    void currentScoreIsBetterThanBestScore() {

        List<TicTacToeFieldKey> listOfFreeKeys = new ArrayList<>();
        listOfFreeKeys.add(One);

        when(board.clone()).thenReturn(board);
        when(board.getKeysOfFreeFields()).thenReturn(listOfFreeKeys);
        when(miniMax.calculateScore()).thenReturn(-10);

        playerOne.doGameMove(board);

        InOrder checkOrder = inOrder(board, miniMax);

        checkOrder.verify(board).getKeysOfFreeFields();
        checkOrder.verify(miniMax).calculateScore();
        checkOrder.verify(board).setPlayer(One,playerOne);

    }

    @Test

    void noFreeFields() {

        when(board.clone()).thenReturn(board);
        when(board.getKeysOfFreeFields()).thenReturn(new ArrayList<>());

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(()->playerOne.doGameMove(board));

    }

}