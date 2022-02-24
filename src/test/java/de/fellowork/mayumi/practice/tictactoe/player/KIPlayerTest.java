package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.GameStateEvaluator;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.ArrayList;
import java.util.List;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.*;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
import static org.mockito.Mockito.*;

class KIPlayerTest {

    private TicTacToeBoard board;
    private TicTacToeBoard copyBoard;
    private GameStateEvaluator evaluator;
    private MiniMax miniMax;

    private Player playerOne;
    private Player tempMiniMaxOpponentDummy;


    @BeforeEach
    void setUp() {

        board = new TicTacToeBoard();
        copyBoard = mock(TicTacToeBoard.class);
        evaluator = mock(GameStateEvaluator.class);
        miniMax = mock(MiniMax.class);
        playerOne = new KIPlayer(PLAYER_SYMBOL_X, miniMax);
        tempMiniMaxOpponentDummy = new MiniMaxPlayer(PLAYER_SYMBOL_O);
    }

    @Test
    void doGameMoveIfCopyBoardHasSpace() {



        List<TicTacToeFieldKey> listOfFreeKeys = new ArrayList<>();
        listOfFreeKeys.add(Five);
        listOfFreeKeys.add(Six);
        listOfFreeKeys.add(Seven);
        listOfFreeKeys.add(Eight);
        listOfFreeKeys.add(Nine);

        when(copyBoard.clone()).thenReturn(board);
        when(copyBoard.getKeysOfFreeFields()).thenReturn(listOfFreeKeys);
        when(copyBoard.isPLayerOnField(One, playerOne)).thenReturn(false);

        playerOne.doGameMove(board);
//        int bestScore = 10;

        InOrder checkOrder = inOrder(copyBoard);
        checkOrder.verify(copyBoard).getKeysOfFreeFields();
        checkOrder.verify(copyBoard).setPlayer(One, playerOne);
        checkOrder.verify(copyBoard).unsetPlayer(One, playerOne);
        checkOrder.verify(board).setPlayer(One, playerOne);

    }

    @Test
    void doGameMoveIfCopyBoardIsFull() {

        List<TicTacToeFieldKey> listOfKeys = new ArrayList<>();
        listOfKeys.add(One);
        listOfKeys.add(Two);
        listOfKeys.add(Three);
        listOfKeys.add(Four);
        listOfKeys.add(Five);
        listOfKeys.add(Six);
        listOfKeys.add(Seven);
        listOfKeys.add(Eight);
        listOfKeys.add(Nine);

        when(copyBoard.isPLayerOnField(One, playerOne)).thenReturn(true);

        playerOne.doGameMove(board);

        InOrder checkOrder = inOrder(copyBoard);
        checkOrder.verify(copyBoard).getKeysOfFreeFields();
        checkOrder.verify(copyBoard).setPlayer(One, playerOne);
        checkOrder.verify(copyBoard).unsetPlayer(One, playerOne);


    }

    @Test
    void minimax() {

    }

    @Test
    void maximizingFunctionMaximizes() {

    }

    @Test
    void minimizingFunctionMinimizes() {

    }


    @Test
    void evaluate() {

    }

}