package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import lombok.Value;

@Value
public class FieldScore implements Comparable<FieldScore>{

    TicTacToeFieldKey fieldKey;
    Integer score;

    @Override
    public int compareTo(FieldScore otherFieldScore) {
        if(score < otherFieldScore.getScore()){
            return 1;
        } else if (score > otherFieldScore.getScore()){
            return -1;
        } else {
            return 0;
        }

    }
}
