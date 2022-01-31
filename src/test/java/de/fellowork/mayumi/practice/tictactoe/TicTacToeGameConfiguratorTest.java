package de.fellowork.mayumi.practice.tictactoe;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeGameConfiguratorTest {

    TicTacToeGameConfigurator configurator = new TicTacToeGameConfigurator();

    @Test
    void testReturnPlayerOneIsHuman(){
        String input = "human";
        InputStream testInput = new ByteArrayInputStream(input.getBytes());

        GameConfiguration conf = configurator.createConfiguration();



    }

}