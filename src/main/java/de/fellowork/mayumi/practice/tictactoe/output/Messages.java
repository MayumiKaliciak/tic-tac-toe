package de.fellowork.mayumi.practice.tictactoe.output;

interface Messages {
    String getWelcomeMessage();
    String getLanguageMessage();

    String getGameConfiguration();

    String getPlayerOption();

    String getFailureMessage();

    String getGameMoveRequest();

    String getDrawOutput();

    String getWinnerOutput();

    String getInvalidFieldKeyOutput();
}
