package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.mockito.Mockito;

import java.time.Duration;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.*;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

class TicTacToeTest {

    @Test
    void runGameKIPlayerVsKIPlayer(){
        TicTacToeInputCollector collectorMock = mock(TicTacToeInputCollector.class);
        when(collectorMock.collectPlayerType()).thenReturn("3");
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.startGame(collectorMock);
    }

    @Test
    void runGameHumanPlayerVsHumanPlayerPlayerOneWins() {

        TicTacToeInputCollector collectorMock = getInputMockHumanVsHuman();

        when(collectorMock.collectGameMove()).thenReturn(One, Three, Two, Four, Six, Five, Seven, Eight, Nine);

        Player winner = runTicTacToe(collectorMock);
        assertThat(winner).isNull();

    }

    @Test
    void runGameHumanPlayerVsHumanPlayerDraw() {

        TicTacToeInputCollector collectorMock = getInputMockHumanVsHuman();

        when(collectorMock.collectGameMove()).thenReturn(Three,Four, Two, Nine, One);

        Player winner = runTicTacToe(collectorMock);
        assertThat(winner).isNotNull();

    }

    private Player runTicTacToe(TicTacToeInputCollector collectorMock) {
        TicTacToe tictactoe = new TicTacToe();
        Player winner = tictactoe.startGame(collectorMock);
        return winner;
    }

    private TicTacToeInputCollector getInputMockHumanVsHuman() {
        TicTacToeInputCollector collectorMock = mock(TicTacToeInputCollector.class);
        when(collectorMock.collectPlayerType()).thenReturn("1");
        return collectorMock;
    }

}