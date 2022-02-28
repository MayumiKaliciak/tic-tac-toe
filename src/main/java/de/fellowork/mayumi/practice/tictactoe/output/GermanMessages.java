package de.fellowork.mayumi.practice.tictactoe.output;

import de.fellowork.mayumi.practice.tictactoe.output.Messages;

class GermanMessages implements Messages {
    @Override
    public String getWelcomeMessage() {
        return "---";
    }
    @Override
    public String getLanguageMessage() {
        return "Spielsprache ist deutsch";
    }
}
