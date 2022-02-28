package de.fellowork.mayumi.practice.tictactoe.output;

class EnglishMessages implements Messages {
    @Override
    public String getWelcomeMessage() {
        return "Welcome to Tic Tac Toe. To access the fields press right keys on your keyboard. Example: To access field top right, press 9";
    }

    @Override
    public String getLanguageMessage() {
        return "Language is set to english";
    }
}
