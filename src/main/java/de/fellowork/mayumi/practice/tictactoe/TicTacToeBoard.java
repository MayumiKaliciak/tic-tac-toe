package de.fellowork.mayumi.practice.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * datenhaltung des spielzustands
 */

public class TicTacToeBoard {

   private final Map<Integer, Player> dataField;

    public TicTacToeBoard() {
        this.dataField = new HashMap<>();

    }

    public Player getPlayer(Integer fieldKey) {
       return dataField.get(fieldKey);

   }



}
