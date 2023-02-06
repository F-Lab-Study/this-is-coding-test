package implementation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class Daily1Test {
    @DisplayName("럭키 스트레이트")
    @ParameterizedTest
    @CsvSource(value = {"123402:LUCKY", "7755:READY"}, delimiter = ':')
    void 럭키_스트레이트(String score, String expected) {
        Assertions.assertEquals(expected, new Daily1(score).luckState());
    }
}