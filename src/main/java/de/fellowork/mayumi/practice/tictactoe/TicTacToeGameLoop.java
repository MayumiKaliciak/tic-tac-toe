package de.fellowork.mayumi.practice.tictactoe;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.output.TicTacToePrinter;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import de.fellowork.mayumi.practice.tictactoe.player.PlayerConfiguration;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Optional;

import static java.util.Optional.empty;
import static java.util.Optional.of;

@AllArgsConstructor
public class TicTacToeGameLoop {

    private final TicTacToePrinter printer;
    private final GameStateEvaluator evaluator;

    public Optional<Player> run(@NonNull TicTacToeBoard board, @NonNull PlayerConfiguration gameConfiguration) {

        Player playerOne = gameConfiguration.getPlayerOne();
        Player playerTwo = gameConfiguration.getPlayerTwo();

        printer.printStartPlayInfo();

        int gameRounds = 1;
        while (!board.boardIsFull()) {

            if (gameRounds % 2 != 0) {
                board = doPlayerMove(board, playerOne);
                if (evaluator.checkPlayerWinningStatus(playerOne, board)) {
                    printer.printPlayerWon(playerOne);
                    return of(playerOne);
                }

            } else {
                board = doPlayerMove(board, playerTwo);
                if (evaluator.checkPlayerWinningStatus(playerTwo, board)) {
                    printer.printPlayerWon(playerTwo);
                    return of(playerTwo);
                }

            }
            gameRounds++;
        }
        printer.printOutDraw();
        return empty();

    }

    private TicTacToeBoard doPlayerMove(TicTacToeBoard board, Player player) {
        printer.printGameMoveRequest();
        board = player.doGameMove(board);
        printer.printBoardToConsole(board);
        return board;
    }

}

