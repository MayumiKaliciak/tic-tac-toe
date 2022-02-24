package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.One;
import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.Two;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.mockito.Mockito.*;


class HumanPlayerTest {

    private TicTacToeBoard board;
    private TicTacToePrinter printer;
    private TicTacToeInputCollector collector;
    private Player playerOne;


    @BeforeEach
    void setUp() {

        board = mock(TicTacToeBoard.class);
        printer = mock(TicTacToePrinter.class);
        collector = mock(TicTacToeInputCollector.class);
        playerOne = new HumanPlayer(PLAYER_SYMBOL_X, printer, collector);
    }


    @Test
    void playerOneIsSetOnBoard() {
        when(collector.collectGameMove()).thenReturn(of(One));

        playerOne.doGameMove(board);
        verify(board).setPlayer(One, playerOne);

    }

    @Test
    void inputIsInvalidKey() {
        when(collector.collectGameMove()).thenReturn(empty(), of(One));

        playerOne.doGameMove(board);
        verify(printer).invalidGameFieldKeyEntered();
        // break while loop
        verify(board).setPlayer(One, playerOne);

    }

    @Test
    void inputOnOccupiedKey() {

        when(collector.collectGameMove()).thenReturn(of(One), of(Two));
        when(board.hasPlayerSet(One)).thenReturn(true);
        when(board.hasPlayerSet(Two)).thenReturn(false);

        playerOne.doGameMove(board);
        InOrder ckeckOrder = inOrder(collector, board, printer);

        // set another player on field One
        ckeckOrder.verify(collector).collectGameMove();
        ckeckOrder.verify(board).hasPlayerSet(One);
        ckeckOrder.verify(printer).invalidGameFieldKeyEntered();
        // break while loop
        ckeckOrder.verify(collector).collectGameMove();
        ckeckOrder.verify(board).hasPlayerSet(Two);
        ckeckOrder.verify(board).setPlayer(Two, playerOne);




    }



}