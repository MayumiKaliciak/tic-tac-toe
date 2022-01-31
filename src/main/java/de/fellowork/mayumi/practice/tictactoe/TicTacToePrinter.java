package de.fellowork.mayumi.practice.tictactoe;

import java.util.function.Consumer;

/**
 * alles zum spielbrett ausgeben oder züge
 * züge ausgeben
 * spielbrett ausgeben
 * gewinner ausgeben
 */
public class TicTacToePrinter {


    public void printOutDefaultBoard(TicTacToeBoard board) {
        System.out.println("This is how the board looks like. To access the fields press right keys on your keyboard. Example: To access field top right, press 9");
        String printedTicTacToe = "7 | 8 | 9\n---------\n4 | 5 | 6\n---------\n1 | 2 | 3\n";
        System.out.println(printedTicTacToe);

        //board.getPlayer()
        // hole alle werte von 1-9 und ersetze im string die zahl durch x/o des spielers




        System.out.println(printedTicTacToe.replace("7","X"));

    }

}
