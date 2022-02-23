package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.input.TicTacToeInputCollector;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicTacToeTest {

    @Test
    void runGameKIPlayerVsKIPlayer() {
        TicTacToeInputCollector collectorMock = mock(TicTacToeInputCollector.class);
        when(collectorMock.collectPlayerType()).thenReturn("3");
        TicTacToe tictactoe = new TicTacToe();
        tictactoe.startGame(collectorMock);
    }

    @Test
    void runGameHumanPlayerVsHumanPlayerPlayerOneWins() {

        TicTacToeInputCollector collectorMock = getInputMockHumanVsHuman();

        when(collectorMock.collectGameMove()).thenReturn(One, Three, Two, Four, Six, Five, Seven, Eight, Nine);

        Optional<Player> winner = runTicTacToe(collectorMock);
        assertThat(winner).isEmpty();

    }

    @Test
    void runGameHumanPlayerVsHumanPlayerDraw() {

        TicTacToeInputCollector collectorMock = getInputMockHumanVsHuman();

        when(collectorMock.collectGameMove()).thenReturn(Three, Four, Two, Nine, One);

        Optional<Player> winner = runTicTacToe(collectorMock);
        assertThat(winner).isPresent();

    }

    private Optional<Player> runTicTacToe(TicTacToeInputCollector collectorMock) {
        TicTacToe tictactoe = new TicTacToe();
        return tictactoe.startGame(collectorMock);
    }

    private TicTacToeInputCollector getInputMockHumanVsHuman() {
        TicTacToeInputCollector collectorMock = mock(TicTacToeInputCollector.class);
        when(collectorMock.collectPlayerType()).thenReturn("1");
        return collectorMock;
    }

}