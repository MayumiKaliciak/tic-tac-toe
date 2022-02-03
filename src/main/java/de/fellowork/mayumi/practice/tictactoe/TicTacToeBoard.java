package de.fellowork.mayumi.practice.tictactoe;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * datenhaltung des spielzustands
 */

public class TicTacToeBoard {

   private final Map<TicTacToeFieldKey, Player> dataField;

    public TicTacToeBoard() {
        this.dataField = new HashMap<>();

    }

    public Player getPlayer(TicTacToeFieldKey fieldKey) {
       return dataField.get(fieldKey);

   }

    public boolean isPLayerOnField(TicTacToeFieldKey fieldKey, Player player) {
        if(hasPlayerSet(fieldKey)){
            return false;
        }
        return player != null && player.equals(getPlayer(fieldKey));
    }

    public boolean setPlayer(TicTacToeFieldKey fieldKey, Player player) {
        if(hasPlayerSet(fieldKey)){
            return false;
        }
        dataField.put(fieldKey,player);
        return true;
    }

    private boolean hasPlayerSet(TicTacToeFieldKey fieldKey) {
        return dataField.containsKey(fieldKey);
    }

}
