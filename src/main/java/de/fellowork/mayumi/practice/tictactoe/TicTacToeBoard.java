package de.fellowork.mayumi.practice.tictactoe;

import lombok.EqualsAndHashCode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

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
        return player != null && player == getPlayer(fieldKey);
    }


    public boolean setPlayer(TicTacToeFieldKey fieldKey, Player player) {
        if (hasPlayerSet(fieldKey)) {
            return false;
        }
        dataField.put(fieldKey, player);
        return true;
    }

    public boolean unsetPlayer(TicTacToeFieldKey fieldKey, Player player) {
        if (!hasPlayerSet(fieldKey)) {
            return false;
        }
        dataField.remove(fieldKey, player);
        return true;
    }

    private boolean hasPlayerSet(TicTacToeFieldKey fieldKey) {
        return dataField.containsKey(fieldKey);
    }


    @Override
    public TicTacToeBoard clone() {
        Map<TicTacToeFieldKey, Player> copyMap = new HashMap<>(dataField);
        return new TicTacToeBoard(copyMap);

    }

    public Set<TicTacToeFieldKey> getKeysOfFreeFields() {
        return TicTacToeFieldKey.toList()
                .stream()
                .filter(key -> !hasPlayerSet(key))
                .collect(toSet());

    }

}
