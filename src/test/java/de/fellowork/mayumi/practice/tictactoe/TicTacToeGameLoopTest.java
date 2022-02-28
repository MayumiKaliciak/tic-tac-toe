package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerConfiguration;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

class TicTacToeGameLoopTest {

    private TicTacToeBoard board;
    private GameStateEvaluator evaluator;
    private TicTacToePrinter printer;
    private Player playerOne;
    private Player playerTwo;
    private PlayerConfiguration config;
    private TicTacToeGameLoop loop;

    @BeforeEach
    void setUp() {
        board = mock(TicTacToeBoard.class);
        evaluator = mock(GameStateEvaluator.class);
        printer = mock(TicTacToePrinter.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        config = new PlayerConfiguration(playerOne, playerTwo);
        loop = new TicTacToeGameLoop(printer, evaluator);
    }

    @Test
    @SuppressWarnings("explicit test of null safety")
    void gameLoopBoardParameterCheck() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> loop.run(null, config));
    }

    @Test
    @SuppressWarnings("explicit test of null safety")
    void gameLoopPlayerConfigParameterCheck() {
        assertThatExceptionOfType(NullPointerException.class).isThrownBy(() -> loop.run(null, config));
    }

    @Test
    void boardIsFullDraw() {

        when(board.boardIsFull()).thenReturn(true);

        Optional<Player> winner = loop.run(board, config);
        assertThat(winner).isEmpty();

        InOrder inOrder = inOrder(printer, board);
        inOrder.verify(printer, times(1)).printStartPlayInfo();
        inOrder.verify(board, times(1)).boardIsFull();
        inOrder.verify(printer, times(1)).printOutDraw();

        verifyNoMoreInteractions(printer);
        verifyNoInteractions(evaluator, playerOne, playerTwo);

    }

    @Test
    void boardIsFullWinnerPlayerOne() {

        when(board.boardIsFull()).thenReturn(false);
        when(playerOne.doGameMove(board)).thenReturn(board);
        when(evaluator.checkPlayerWinningStatus(playerOne, board)).thenReturn(true);

        Optional<Player> winner = loop.run(board, config);
        assertThat(winner).isPresent();
        assertThat(winner.get()).isEqualTo(playerOne);

        InOrder inOrder = inOrder(printer, board);
        inOrder.verify(printer, times(1)).printStartPlayInfo();
        inOrder.verify(board, times(1)).boardIsFull();
        inOrder.verify(printer, times(1)).printGameMoveRequest();
        inOrder.verify(printer, times(1)).printBoardToConsole(board);
        inOrder.verify(printer, times(1)).printPlayerWon(playerOne);

    }

    @Test
    void boardIsFullWinnerPlayerTwo() {

        when(board.boardIsFull()).thenReturn(false, false);
        when(playerOne.doGameMove(board)).thenReturn(board);
        when(evaluator.checkPlayerWinningStatus(playerOne, board)).thenReturn(false);
        when(playerTwo.doGameMove(board)).thenReturn(board);
        when(evaluator.checkPlayerWinningStatus(playerTwo, board)).thenReturn(true);

        Optional<Player> winner = loop.run(board, config);
        assertThat(winner).isPresent();
        assertThat(winner.get()).isEqualTo(playerTwo);

        InOrder inOrder = inOrder(printer, board);

        //first loop iteration for PlayerOne (does not win)
        inOrder.verify(printer, times(1)).printStartPlayInfo();
        inOrder.verify(board, times(1)).boardIsFull();
        inOrder.verify(printer, times(1)).printGameMoveRequest();
        inOrder.verify(printer, times(1)).printBoardToConsole(board);

        //second loop iteration for PlayerTwo (does win)
        inOrder.verify(board, times(1)).boardIsFull();
        inOrder.verify(printer, times(1)).printGameMoveRequest();
        inOrder.verify(printer, times(1)).printBoardToConsole(board);
        inOrder.verify(printer, times(1)).printPlayerWon(playerTwo);
    }


}