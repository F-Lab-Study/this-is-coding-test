package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Daily5Test {
    @DisplayName("볼링공 고르기")
    @ParameterizedTest
    @CsvSource(value = { "5 3:1 3 2 3 2:8", "8 5:1 5 4 3 2 4 5 2:25" }, delimiter = ':')
    void 볼링공_만들기(String input1, String input2, int expected) {
        Assertions.assertEquals(expected, new Daily5(input1, input2).solution());
    }
}