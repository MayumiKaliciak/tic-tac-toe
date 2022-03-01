package de.fellowork.mayumi.practice.tictactoe.input;

import de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.Scanner;

import static de.fellowork.mayumi.practice.tictactoe.board.TicTacToeFieldKey.One;
import static de.fellowork.mayumi.practice.tictactoe.input.GameModeKey.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DefaultInputCollectorTest {

    private Scanner scanner;
    private DefaultInputCollector collector;

    @BeforeEach
    void setUp() {
        scanner = mock(Scanner.class);
        collector = new DefaultInputCollector(scanner);
    }

    @Test
    void playerTypeHumanHuman(){

        when(scanner.nextLine()).thenReturn("1");

        GameModeKey gameModeKey = collector.collectPlayerType();
        assertThat(gameModeKey).isEqualTo(HumanHuman);
    }

    @Test
    void playerTypeUndefined(){

        when(scanner.nextLine()).thenReturn("invalidInput");

        GameModeKey gameModeKey = collector.collectPlayerType();
        assertThat(gameModeKey).isEqualTo(Undefined);
    }

    @Test
    void collectGameMoveFieldKeyOne(){

        when(scanner.nextLine()).thenReturn("1");

        Optional<TicTacToeFieldKey> fieldKey = collector.collectGameMove();
        assertThat(fieldKey).isPresent();
        assertThat(fieldKey.get()).isEqualTo(One);
    }

    @Test
    void collectGameMoveUnknownMove(){

        when(scanner.nextLine()).thenReturn("invalidInput");

        Optional<TicTacToeFieldKey> fieldKey = collector.collectGameMove();
        assertThat(fieldKey).isEmpty();
    }
}