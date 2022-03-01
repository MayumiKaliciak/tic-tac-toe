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

    @Override
    public String getGameConfiguration() {
        return "The options to play Tic Tac Toe are: \n1: human-human\n2: human-computer\n3: computer-computer";
    }

    @Override
    public String getPlayerOption() {
        return "Please select option by typing in correct option number";
    }

    @Override
    public String getFailureMessage() {
        return "Not able to recognize input. Please try again choosing one number";
    }

    @Override
    public String getGameMoveRequest() {
        return "Please select field";
    }

    @Override
    public String getDrawOutput() {
        return "Draw! Nobody has won the game";
    }

    @Override
    public String getWinnerOutput() {
        return "The winner is Player: ";
    }

    @Override
    public String getInvalidFieldKeyOutput() {
        return "You entered an invalid field number. Try again.";
    }


}
