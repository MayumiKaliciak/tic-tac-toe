package de.fellowork.mayumi.practice.tictactoe;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeBoardTest {



    @Test
    void isPLayerOnField(){
        TestPlayer testPlayer = new TestPlayer();
        TicTacToeBoard board = new TicTacToeBoard();
        board.setPlayer(TicTacToeFieldKey.Nine, testPlayer);
        boolean pLayerOnField = board.isPLayerOnField(TicTacToeFieldKey.Nine, testPlayer);
        assertTrue(pLayerOnField);

    }
    @Test
    void secondPLayerOnField(){
        TestPlayer testPlayer = new TestPlayer();
        TestPlayer testPlayer2 = new TestPlayer();
        TicTacToeBoard board = new TicTacToeBoard();
        board.setPlayer(TicTacToeFieldKey.Nine, testPlayer);

        boolean pLayerOnField = board.isPLayerOnField(TicTacToeFieldKey.Nine, testPlayer);
        assertTrue(pLayerOnField);
        boolean pLayerNotOnField = board.isPLayerOnField(TicTacToeFieldKey.Nine, testPlayer2);
        assertFalse(pLayerNotOnField);
    }

}