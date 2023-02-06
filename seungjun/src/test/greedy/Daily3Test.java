package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class Daily3Test {
    @DisplayName("문자열 뒤집기")
    @ParameterizedTest
    @CsvSource(value = { "0001100:1", "11010010:3" }, delimiter = ':')
    void 문자열_뒤집기(String input, int output) {
        Assertions.assertEquals(output, new Daily3(input).solution());
    }
}