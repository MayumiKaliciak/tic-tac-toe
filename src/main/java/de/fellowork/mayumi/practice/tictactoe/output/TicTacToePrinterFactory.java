package de.fellowork.mayumi.practice.tictactoe.output;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TicTacToePrinterFactory {

    private final ConsoleOutput consoleOutput;

    public TicTacToePrinter createPrinter() {
        Messages messages;
        String language = System.getProperty("lang");
        if("de".equals(language)) {
            messages = new GermanMessages();
        } else {
            messages = new EnglishMessages();
        }
        return new TicTacToePrinter(consoleOutput, messages);
    }
}
