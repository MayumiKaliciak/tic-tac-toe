package de.fellowork.mayumi.practice.tictactoe;

import org.assertj.core.internal.Maps;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class TicTacToeBoardTest {

    @Test
    void isPLayerOnField(){
        TestPlayer testPlayer = new TestPlayer();
        TicTacToeBoard board = new TicTacToeBoard();
        board.setPlayer(TicTacToeFieldKey.Nine, testPlayer);
        boolean pLayerOnField = board.isPLayerOnField(TicTacToeFieldKey.Nine, testPlayer);
        assertThat(pLayerOnField).isTrue();

    }
    @Test
    void secondPLayerOnField(){
        TestPlayer testPlayer = new TestPlayer();
        TestPlayer testPlayer2 = new TestPlayer();
        TicTacToeBoard board = new TicTacToeBoard();
        board.setPlayer(TicTacToeFieldKey.Nine, testPlayer);

        boolean pLayerOnField = board.isPLayerOnField(TicTacToeFieldKey.Nine, testPlayer);
        assertThat(pLayerOnField).isTrue();
        boolean pLayerNotOnField = board.isPLayerOnField(TicTacToeFieldKey.Nine, testPlayer2);
        assertThat(pLayerNotOnField).isFalse();
    }

    @Test
    void cloneBoard(){
        TestPlayer testPlayer = new TestPlayer();
        TicTacToeBoard board = new TicTacToeBoard();
        TicTacToeBoard copy = board.clone();
        assertThat(board).isNotSameAs(copy);
        assertThat(board).isEqualTo(copy);

        copy.setPlayer(TicTacToeFieldKey.Nine, testPlayer);
        assertThat(board).isNotEqualTo(copy);
    }

    @Test
    void getFreeFields() {
        TicTacToeBoard board = new TicTacToeBoard();
        List<TicTacToeFieldKey> freeFields = board.getKeysOfFreeFields();
        int expected = TicTacToeFieldKey.toList().size();
        assertThat(freeFields).hasSize(expected);

    }


    @Test
    void getFreeFieldsAfterSettingField() {
        TicTacToeBoard board = new TicTacToeBoard();
        TestPlayer testPlayer = new TestPlayer();
        board.setPlayer(TicTacToeFieldKey.Nine, testPlayer);
        List<TicTacToeFieldKey> freeFields = board.getKeysOfFreeFields();

        assertThat(freeFields).doesNotContain(TicTacToeFieldKey.Nine);

    }

}