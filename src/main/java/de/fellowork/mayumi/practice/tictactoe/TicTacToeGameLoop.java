package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TicTacToeGameLoop {

    private final TicTacToePrinter printer;
    private final GameStateEvaluator evaluator;

    public void run(TicTacToeBoard board,GameConfiguration gameConfiguration) {

        Player playerOne = gameConfiguration.getPlayerOne();
        Player playerTwo = gameConfiguration.getPlayerTwo();

        printer.printStartPlayInfo();

        for (int gameRounds = 1; gameRounds <=9 ; gameRounds++) {


            if (gameRounds % 2 != 0) {
                board = doPlayerMove(board, playerOne);
                if(evaluator.checkPLayerWinningStatus(playerOne, board)){
                    printer.printPlayerWon(playerOne);
                    return;
                }

            } else {
                board = doPlayerMove(board, playerTwo);
                if(evaluator.checkPLayerWinningStatus(playerTwo, board)){
                    printer.printPlayerWon(playerTwo);
                    return;
                }

            }
        }
        printer.printOutDraw();

    }

    private TicTacToeBoard doPlayerMove(TicTacToeBoard board, Player player) {
        printer.printGameMoveRequest();
        board = player.doGameMove(board);
        printer.printBoardToConsole(board);
        return board;
    }

}

