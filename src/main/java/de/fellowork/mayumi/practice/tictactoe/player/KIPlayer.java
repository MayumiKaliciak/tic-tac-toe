package de.fellowork.mayumi.practice.tictactoe.player;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.player.minimax.MiniMax;
import de.fellowork.mayumi.practice.tictactoe.player.minimax.MinimaxFactory;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

@RequiredArgsConstructor
class KIPlayer implements Player {

    private final PlayerSymbol playerSymbol;
    private final MinimaxFactory minimaxFactory;
    private final ExecutorService executor;

    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        FieldScore fieldScore = board.getKeysOfFreeFields()
                .stream()
                .map(fieldKey -> run(fieldKey, board))
                .map(this::getFuture)
                .sorted()
                .findFirst()
                .orElseThrow(() ->  new RuntimeException("unable to calculate optimal fieldKey"));

        board.setPlayer(fieldScore.getFieldKey(), this);
        return board;

    }

    @SneakyThrows
    private FieldScore getFuture(Future<FieldScore> fieldScoreFuture) {
        return fieldScoreFuture.get();
    }

    private Future<FieldScore> run(TicTacToeFieldKey fieldKey, TicTacToeBoard board) {
        return executor.submit(() -> {
            MiniMax miniMax = createMiniMax(board, fieldKey);
            System.out.println("begin");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end");
            int score = miniMax.calculateScore();
            return new FieldScore(fieldKey, score);
        });
    }

    private MiniMax createMiniMax(TicTacToeBoard board, TicTacToeFieldKey fieldKey) {
        TicTacToeBoard copyBoard = board.clone();
        copyBoard.setPlayer(fieldKey, this);
        return minimaxFactory.buildMiniMax(this, copyBoard);
    }

    @Override
    public PlayerSymbol getPlayerSymbol() {
        return playerSymbol;
    }

}