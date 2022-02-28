package de.fellowork.mayumi.practice.tictactoe.output;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

class TicTacToePrinterFactoryTest {

    @Test
    void englishVersion(){
        System.setProperty("lang", "en");
        testLanguage("Language is set to english");
    }

    @Test
    void germanVersion(){

        System.setProperty("lang", "de");
        testLanguage("Spielsprache ist deutsch");
    }

    private void testLanguage(String outputMessage) {
        ConsoleOutput consoleOutput = mock(ConsoleOutput.class);

        TicTacToePrinterFactory printerFactory = new TicTacToePrinterFactory(consoleOutput);
        TicTacToePrinter printer = printerFactory.createPrinter();
        printer.printLanguageSetting();

        verify(consoleOutput).printToConsole(outputMessage);
    }

}