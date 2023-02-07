package implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Daily8Test {
    @ParameterizedTest
    @CsvSource(value = { "K1KA5CB7:ABCKK13", "AJKDLSI412K4JSJ9D:ADDIJJJKKLSS20" }, delimiter = ':')
    void test(String input, String expected) {
        Assertions.assertEquals(expected, new Daily8(input).getResult());
    }
}