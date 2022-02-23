package de.fellowork.mayumi.practice.tictactoe.board;

import de.fellowork.mayumi.practice.tictactoe.player.Player;
import lombok.EqualsAndHashCode;

import java.util.*;

/**
 * datenhaltung des spielzustands
 */
@EqualsAndHashCode
public class TicTacToeBoard implements Cloneable {

    private final Map<TicTacToeFieldKey, Player> dataField;

    public TicTacToeBoard() {
        this.dataField = new HashMap<>();

    }

    public TicTacToeBoard(Map<TicTacToeFieldKey, Player> dataField) {
        this.dataField = dataField;

    }

    public Player getPlayer(TicTacToeFieldKey fieldKey) {
        return dataField.get(fieldKey);

    }

    public boolean isPLayerOnField(TicTacToeFieldKey fieldKey, Player player) {
        if (!hasPlayerSet(fieldKey)) {
            return false;
        }
        return player != null && player.compareSymbols(getPlayer(fieldKey));
    }


    public void setPlayer(TicTacToeFieldKey fieldKey, Player player) {
        if (hasPlayerSet(fieldKey)) {
            return;
        }
        dataField.put(fieldKey, player);
    }

    public void unsetPlayer(TicTacToeFieldKey fieldKey, Player player) {
        if (!hasPlayerSet(fieldKey)) {
            return;
        }
        dataField.remove(fieldKey, player);
    }

    private boolean hasPlayerSet(TicTacToeFieldKey fieldKey) {
        return dataField.containsKey(fieldKey);
    }


    @Override
    public TicTacToeBoard clone() {
        Map<TicTacToeFieldKey, Player> copyMap = new HashMap<>(dataField);
        return new TicTacToeBoard(copyMap);

    }

    public List<TicTacToeFieldKey> getKeysOfFreeFields() {
        return TicTacToeFieldKey.toList()
                .stream()
                .filter(key -> !hasPlayerSet(key))
                .toList();

    }

    public boolean boardIsFull() {
        return getKeysOfFreeFields().isEmpty();

    }

}
