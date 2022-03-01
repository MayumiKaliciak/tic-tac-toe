package de.fellowork.mayumi.practice.tictactoe.output;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeBoard;
import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import de.fellowork.mayumi.practice.tictactoe.player.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static de.fellowork.mayumi.practice.tictactoe.player.PlayerSymbol.PLAYER_SYMBOL_X;
import static org.mockito.Mockito.*;

class TicTacToePrinterTest {

    private TicTacToePrinter printer;
    private ConsoleOutput consoleOutput;
    private Messages messages;

    @BeforeEach
    void setUp() {

        consoleOutput = mock(ConsoleOutput.class);
        messages = mock(Messages.class);
        printer = new TicTacToePrinter(consoleOutput, messages);
    }

    @Test
    void printLanguageSetting() {

        String output = "xyz";
        when(messages.getLanguageMessage()).thenReturn(output);

        printer.printLanguageSetting();

        InOrder checkOrder = inOrder(messages, consoleOutput);
        checkOrder.verify(messages).getLanguageMessage();
        checkOrder.verify(consoleOutput).printToConsole(output);

    }

    @Test
    void printStartPlayInfo() {

        String output = "xyz";
        String printedTicTacToe = printer.getPrintedTicTacToe();
        when(messages.getWelcomeMessage()).thenReturn(output);

        printer.printStartPlayInfo();

        InOrder checkOrder = inOrder(messages, consoleOutput);
        checkOrder.verify(messages).getWelcomeMessage();
        checkOrder.verify(consoleOutput).printToConsole(output);
        checkOrder.verify(consoleOutput).printToConsole(printedTicTacToe);

    }

    @Test
    void printGameConfiguration() {

        String output = "xyz";
        when(messages.getGameConfiguration()).thenReturn(output);

        printer.printGameConfiguration();

        InOrder checkOrder = inOrder(messages, consoleOutput);
        checkOrder.verify(messages).getGameConfiguration();
        checkOrder.verify(consoleOutput).printToConsole(output);
    }

    @Test
    void printChoosePlayerOption() {

        String output = "xyz";
        when(messages.getPlayerOption()).thenReturn(output);

        printer.printChoosePlayerOption();

        InOrder checkOrder = inOrder(messages, consoleOutput);
        checkOrder.verify(messages).getPlayerOption();
        checkOrder.verify(consoleOutput).printToConsole(output);
    }

    @Test
    void printFailureMessage() {

        String output = "xyz";
        when(messages.getFailureMessage()).thenReturn(output);

        printer.printFailureMessage();

        InOrder checkOrder = inOrder(messages, consoleOutput);
        checkOrder.verify(messages).getFailureMessage();
        checkOrder.verify(consoleOutput).printToConsole(output);
    }

    @Test
    void printGameMoveRequest() {

        String output = "xyz";
        when(messages.getGameMoveRequest()).thenReturn(output);

        printer.printGameMoveRequest();

        InOrder checkOrder = inOrder(messages, consoleOutput);
        checkOrder.verify(messages).getGameMoveRequest();
        checkOrder.verify(consoleOutput).printToConsole(output);
    }

    @Test
    void printBoardToConsole() {

        for (TicTacToeFieldKey key : TicTacToeFieldKey.toList()) {
            TicTacToeBoard board = new TicTacToeBoard();
            Player player = mock(Player.class);
            board.setPlayer(key, player);

            when(player.getPlayerSymbol()).thenReturn(PLAYER_SYMBOL_X);

            printer.printBoardToConsole(board);
            String expectedOutput = printer.getPrintedTicTacToe().replace(key.getNumberAsString(), PLAYER_SYMBOL_X.getSymbolAsString());
            verify(player).getPlayerSymbol();
            verify(consoleOutput).printToConsole(expectedOutput);
        }
    }

    @Test
    void printBoardToConsoleNoPlayerSet() {

        TicTacToeBoard board = new TicTacToeBoard();

        printer.printBoardToConsole(board);

        verify(consoleOutput).printToConsole(printer.getPrintedTicTacToe());
    }

    @Test
    void printOutDraw() {

        String output = "xyz";
        when(messages.getDrawOutput()).thenReturn(output);

        printer.printOutDraw();

        InOrder checkOrder = inOrder(messages, consoleOutput);
        checkOrder.verify(messages).getDrawOutput();
        checkOrder.verify(consoleOutput).printToConsole(output);
    }

    @Test
    void printPlayerWon() {

        String output = "xyz";
        Player player = mock(Player.class);
        when(messages.getWinnerOutput()).thenReturn(output);
        when(player.getPlayerSymbol()).thenReturn(PLAYER_SYMBOL_X);

        printer.printPlayerWon(player);

        InOrder checkOrder = inOrder(messages, player, consoleOutput);
        checkOrder.verify(messages).getWinnerOutput();
        checkOrder.verify(player).getPlayerSymbol();
        checkOrder.verify(consoleOutput).printToConsole(output + PLAYER_SYMBOL_X);
    }

    @Test
    void invalidGameFieldKeyEntered() {

        String output = "xyz";
        when(messages.getInvalidFieldKeyOutput()).thenReturn(output);

        printer.invalidGameFieldKeyEntered();

        InOrder checkOrder = inOrder(messages, consoleOutput);
        checkOrder.verify(messages).getInvalidFieldKeyOutput();
        checkOrder.verify(consoleOutput).printToConsole(output);
    }
}