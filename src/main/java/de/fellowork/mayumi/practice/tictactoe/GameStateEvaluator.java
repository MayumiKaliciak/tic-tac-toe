package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GameStateEvaluator {

    private final TicTacToeBoard board;

    public boolean gameIsOver(TicTacToeBoard board) {
        return winnerExists() || draw();
    }

    public boolean winnerExists(){
        return sameValuesInColumn() || sameValuesInRow() || sameValuesInDiagonal();
    }

    public boolean draw() {
        return !winnerExists();
    }

    //TODO Gewinnbedingungen formulieren

    public boolean sameValuesInColumn(){
        // wenn 7, 4, 1 || 8, 5, 2 || 9, 6, 3 gleichen value haben
        return true;
    }

    public boolean sameValuesInRow(){
        // wenn 7, 8, 9 || 4, 5, 6 || 1, 2, 3 gleichen value haben
        return true;
    }

    public boolean sameValuesInDiagonal(){
        // wenn 7, 5, 3 || 1, 5, 9 gleichen value haben
        return true;
    }

    public boolean playerOneWon(){
        // wenn winnerExists() und
        // in Column, Row oder Diagonal PlayerOne steht

        return true;
    }

    public boolean playerTwoWon(){
        // wenn winnerExists() und
        // in Column, Row oder Diagonal PlayerTwo steht

        return true;
    }





}
