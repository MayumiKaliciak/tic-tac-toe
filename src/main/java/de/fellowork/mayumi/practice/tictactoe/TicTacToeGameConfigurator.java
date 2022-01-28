package de.fellowork.mayumi.practice.tictactoe;

/**
 * wer spielt gegen wen? (h-ki,hu-hu,ki-ki)? start: hu-hu, hu-ki erfordert nur anpassung in config impl
 *
 *
 * welcher spieler beginnt
 */


public class TicTacToeGameConfigurator {


    public GameConfiguration createConfiguration(){

        Player playerOne = new HumanPlayer();
        Player playerTwo = new HumanPlayer();


        return new GameConfiguration(playerOne, playerTwo);
    }

}
