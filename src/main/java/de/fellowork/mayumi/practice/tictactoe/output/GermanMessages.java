package de.fellowork.mayumi.practice.tictactoe.output;

import de.fellowork.mayumi.practice.tictactoe.output.Messages;

class GermanMessages implements Messages {
    @Override
    public String getWelcomeMessage() {
        return "Willkommen bei Tic Tac Toe. Um die Felder zu bedienen, bitte die Zahlen am rechten Rand der Tastatur verwenden. Beispiel: Um das Feld oben rechts zu besetzen, bitte Taste 9 betätigen";
    }
    @Override
    public String getLanguageMessage() {
        return "Spielsprache ist deutsch";
    }

    @Override
    public String getGameConfiguration() {
        return "Die Spielvarianten für Tic Tac Toe sind: \n1: Mensch - Mensch\n2: Mensch - Computer\n3: Computer - Computer";
    }

    @Override
    public String getPlayerOption() {
        return "Bitte mit der passenden Zahl eine Spielvariante auswählen";
    }

    @Override
    public String getFailureMessage() {
        return "Input nicht erkannt. Bitte erneut eine Nummer wählen";
    }

    @Override
    public String getGameMoveRequest() {
        return "Bitte ein freies Feld für den Spielzug auswählen";
    }

    @Override
    public String getDrawOutput() {
        return "Unentschieden! Keiner hat gewonnen";
    }

    @Override
    public String getWinnerOutput() {
        return "Der Gewinner ist Spieler: ";
    }

    @Override
    public String getInvalidFieldKeyOutput() {
        return "Ungültiger Platz für den Spielzug ausgewählt. Bitte erneut ein freies Feld für den Spielzug auswählen";
    }
}
