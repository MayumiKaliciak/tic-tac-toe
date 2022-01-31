package de.fellowork.mayumi.practice.tictactoe;

import java.util.Objects;
import java.util.Scanner;

/**
 * wer spielt gegen wen? (h-ki,hu-hu,ki-ki)? start: hu-hu, hu-ki erfordert nur anpassung in config impl
 *
 *
 * welcher spieler beginnt
 */


public class TicTacToeGameConfigurator {

    private final Scanner scanner = new Scanner(System.in);


    public GameConfiguration createConfiguration(){

        Player playerOne = null;
        Player playerTwo = null;
        System.out.println("The options to play TicTacToe are: \n1: human-human\n2: human-computer\n3: computer-computer");

        playerOne = getPlayerOne(playerOne);
        playerTwo = getPlayerTwo(playerTwo);

        return new GameConfiguration(playerOne, playerTwo);
    }

    private Player getPlayerOne(Player playerOne) {

        while(!firstPlayerIsHuman() && !firstPlayerIsComputer()) {
            System.out.println("Please select player one by typing in 'human' or 'computer'");
            if (firstPlayerIsHuman()) {
                playerOne = new HumanPlayer();
            }
            if (firstPlayerIsComputer()) {
                playerOne = new KIPlayer();
            }
        }
        return playerOne;
    }


    private boolean firstPlayerIsHuman() {

        String firstPlayer = scanner.nextLine();
        if(firstPlayer == "human"){
            return true;
        } else {
            return false;
        }
    }

    private boolean firstPlayerIsComputer() {

        String firstPlayer = scanner.nextLine();
        if(firstPlayer == "computer"){
            return true;
        } else {
            return false;
        }
    }

    private Player getPlayerTwo(Player playerTwo) {

        while(!secondPlayerIsHuman() && !secondPlayerIsComputer()) {
            System.out.println("Please select player one by typing in 'human' or 'computer'");
            if (secondPlayerIsHuman()) {
                playerTwo = new HumanPlayer();
            }
            if (secondPlayerIsComputer()) {
                playerTwo = new KIPlayer();
            }
        }
        return playerTwo;
    }

    private boolean secondPlayerIsHuman() {

        String secondPlayer = scanner.nextLine();
        if(Objects.equals(secondPlayer, "human")){
            return true;
        } else {
            return false;
        }
    }

    private boolean secondPlayerIsComputer() {

        String secondPlayer = scanner.nextLine();
        if(Objects.equals(secondPlayer, "computer")){
            return true;
        } else {
            return false;
        }
    }


}
