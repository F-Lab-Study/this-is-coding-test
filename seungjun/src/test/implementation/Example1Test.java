package implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class Example1Test {
    @DisplayName("상하좌우")
    @ParameterizedTest
    @CsvSource(value = {"5:R R R U D D:3 4"}, delimiter = ':')
    void 상하좌우(int coordinateSize, String commendString, String expected) {
        Assertions.assertEquals(expected, new Example1(coordinateSize, commendString).solution());
    }
}