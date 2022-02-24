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
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
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

        board = new TicTacToeBoard();
        copyBoard = mock(TicTacToeBoard.class);
        miniMax = mock(MiniMax.class);
        minimaxFactory = mock(MinimaxFactory.class);
        playerOne = new KIPlayer(PLAYER_SYMBOL_X, minimaxFactory);

        when(minimaxFactory.buildMiniMax(playerOne)).thenReturn(miniMax);
    }

    @Test
    void doGameMoveIfCopyBoardHasSpace() {

        List<TicTacToeFieldKey> listOfFreeKeys = new ArrayList<>();
        listOfFreeKeys.add(One);

        when(copyBoard.getKeysOfFreeFields()).thenReturn(listOfFreeKeys);
        when(miniMax.minimax(false, copyBoard)).thenReturn(-10);

        playerOne.doGameMove(board);

        InOrder checkOrder = inOrder(copyBoard, minimaxFactory, miniMax);

        checkOrder.verify(copyBoard).getKeysOfFreeFields();
        checkOrder.verify(copyBoard).setPlayer(One, playerOne);
        checkOrder.verify(minimaxFactory).buildMiniMax(playerOne);
        checkOrder.verify(miniMax).minimax(false, copyBoard);
        checkOrder.verify(copyBoard).unsetPlayer(One, playerOne);

//        assertNotEquals(Collections.emptyMap(), board);

    }

    @Test
    void doGameMoveIfNoSpaceIsLeft() {

        List<TicTacToeFieldKey> listOfFreeKeys = new ArrayList<>();
//        listOfFreeKeys.add(One);
//        listOfKeys.add(Two);
//        listOfKeys.add(Three);
//        listOfKeys.add(Four);
//        listOfKeys.add(Five);
//        listOfKeys.add(Six);
//        listOfKeys.add(Seven);
//        listOfKeys.add(Eight);
//        listOfKeys.add(Nine);

        when(copyBoard.isPLayerOnField(One, playerOne)).thenReturn(false);
        when(copyBoard.getKeysOfFreeFields()).thenReturn(Collections.emptyList());
        when(copyBoard.isPLayerOnField(One, playerOne)).thenReturn(true);

        playerOne.doGameMove(board);

        InOrder checkOrder = inOrder(copyBoard);
        checkOrder.verify(copyBoard).getKeysOfFreeFields();
        checkOrder.verify(copyBoard).isPLayerOnField(One, playerOne);



    }

    @Test
    void minimax() {

    }


}