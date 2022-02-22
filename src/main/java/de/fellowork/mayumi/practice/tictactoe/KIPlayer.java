package de.fellowork.mayumi.practice.tictactoe;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class KIPlayer implements Player {


    private final String playerSymbol;


    @Override
    public TicTacToeBoard doGameMove(TicTacToeBoard board) {

        TicTacToeBoard copyBoard = board.clone();

        int bestScore = Integer.MIN_VALUE;
      /**  while (copyBoard.isMoveLeft(fieldKey)) {
            if (!copyBoard.isPLayerOnField(fieldKey, this)) {
                copyBoard.setPlayer(fieldKey, this);
                int score = minimax(false);
                copyBoard.unsetPlayer(fieldKey, this);
                if (score > bestScore) {
                    bestScore = score;
                }
            }
        }
        if (bestScore != Integer.MIN_VALUE) {
            board.setPlayer(fieldKey, this);
        }**/
        return board;
    }

    public int minimax(boolean isMaximizingPlayer){
        int hightOfTree = 9;
        int alpha = Integer.MIN_VALUE;
        int beta = Integer.MAX_VALUE;

        if(isMaximizingPlayer) {
            // maximize
        } else {
            // minimize
        }

        return 1;
    }

    @Override
    public String getPlayerSymbol() {
        return playerSymbol;
    }




//
//    fun minimax(
//            maximizingPlayer: Boolean,
//            depth: Int = matrixDimension * matrixDimension,
//            alpha: Int = Int.MIN_VALUE,
//            beta: Int = Int.MAX_VALUE,
//            ): Int {
//
//        val winner = checkWinner(maximizingPlayer)
//        if (winner != NONE) {
//            return evaluate(maximizingPlayer)
//        }
//
//        if (isBoardFull()) {
//            return 0;
//        }
//
//        return if (maximizingPlayer) {
//            maximize(depth, alpha, beta)
//        } else {
//            minimize(depth, alpha, beta)
//        }
//    }
//
//    private fun maximize(depth: Int, alpha: Int, beta: Int): Int {
//        var maxEval = Int.MIN_VALUE
//        for (row in 0..maxIndex) {
//            for (column in 0..maxIndex) {
//                val entry = fields[row][column]
//                if (!entry.hasPlayerSet()) {
//                    entry.setPlayer(X)
//                    var eval = minimax( false,depth - 1)
//                    entry.setPlayer(NONE)
//                    maxEval = Integer.max(maxEval, eval)
//                }
//            }
//        }
//        return maxEval
//    }
//
//    private fun minimize(depth: Int, alpha: Int, beta: Int): Int {
//        var minEval = Int.MAX_VALUE
//        for (row in 0..maxIndex) {
//            for (column in 0..maxIndex) {
//                val entry = fields[row][column]
//                if (!entry.hasPlayerSet()) {
//                    entry.setPlayer(O)
//                    var eval = minimax( true,depth - 1)
//                    entry.setPlayer(NONE)
//                    minEval = Integer.min(minEval, eval)
//                }
//            }
//        }
//        return minEval
//    }
//
//    private fun evaluate(maximizingPlayer: Boolean): Int {
//        return if (maximizingPlayer) {
//            10
//        } else {
//            -10
//        }
//    }






////        int bestValForMax = Integer.MIN_VALUE;
////
////        for (TicTacToeFieldKey fieldkey : board.clone()) {
////            board.isPLayerOnField(fieldKey, player);
////        }
////
////    }
//
//
//    private int minimax(TicTacToeBoard board, GameStateEvaluator evaluator, Player player, isMaximizingPlayer()) {
//
//        // minimax only starts if gameLoop says that board has space
//
//        int currentDepth = 0;
//        int hightOfTree = 9;
//        int currentKey = 0;
//
//        while (currentDepth <= 9) {
//
//            if (isMaximizingPlayer()) {
//                int bestValForMax = Integer.MIN_VALUE;
////            for each field in map
////              if (board.isMoveLeft()){
////              //                set Player
////              }
//
//
//                currentDepth++;
//                int value = minimax(board, evaluator, player, false);
//                bestValForMax = Math.min(bestValForMax, value);
//
//                return bestValForMax;
//
//
//
//            } else {
//                int bestValForMin = Integer.MAX_VALUE;
////            for each move in board :
////            value = minimax(board, currentDepth+1, true)
//                bestValForMin = Math.min(bestValForMin, value);
//
//                return bestValForMin;
//            }
//
//
//        }
//    }
//
//
//    private boolean isMaximizingPlayer() {
//
////        if is maximizing players turn
//        return true;
////                        else return false
//
//    }




}

