package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.*;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_O;
import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class TicTacToeBoardTest {

    private Player playerOne;
    private Player playerTwo;

    @BeforeEach
    void setUp() {

        playerOne = mock(Player.class);
        when(playerOne.getPlayerSymbol()).thenReturn(PLAYER_SYMBOL_X);
        when(playerOne.compareSymbols(any())).thenCallRealMethod();

        playerTwo = mock(Player.class);
        when(playerTwo.getPlayerSymbol()).thenReturn(PLAYER_SYMBOL_O);
        when(playerTwo.compareSymbols(any())).thenCallRealMethod();

    }

    @Test
    void isPLayerOnField() {

        TicTacToeBoard board = new TicTacToeBoard();
        board.setPlayer(Nine, playerOne);
        boolean pLayerOnField = board.isPLayerOnField(Nine, playerOne);
        assertThat(pLayerOnField).isTrue();

    }

    @Test
    void secondPLayerOnField() {

        TicTacToeBoard board = new TicTacToeBoard();
        board.setPlayer(Nine, playerOne);

        boolean pLayerOnField = board.isPLayerOnField(Nine, playerOne);
        assertThat(pLayerOnField).isTrue();
        boolean pLayerNotOnField = board.isPLayerOnField(Nine, playerTwo);
        assertThat(pLayerNotOnField).isFalse();
    }

    @Test
    void cloneBoard() {

        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeBoard copy = board.clone();
        assertThat(board).isNotSameAs(copy);
        assertThat(board).isEqualTo(copy);

        copy.setPlayer(Nine, playerOne);
        assertThat(board).isNotEqualTo(copy);
    }

    @Test
    void getFreeFields() {
        TicTacToeBoard board = new TicTacToeBoard();
        List<TicTacToeFieldKey> freeFields = board.getKeysOfFreeFields();
        int expected = toList().size();
        assertThat(freeFields).hasSize(expected);

    }


    @Test
    void getFreeFieldsAfterSettingField() {
        TicTacToeBoard board = new TicTacToeBoard();

        board.setPlayer(Nine, playerOne);
        List<TicTacToeFieldKey> freeFields = board.getKeysOfFreeFields();

        assertThat(freeFields).doesNotContain(Nine);

    }

}