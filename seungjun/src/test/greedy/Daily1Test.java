package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class Daily1Test {
    @DisplayName("모험가 길드")
    @ParameterizedTest
    @CsvSource(value = { "5:2 3 1 2 2:2", "10:1 1 1 5 3 7 8 9 3 2:4" }, delimiter = ':')
    void 모험가_길드(int amountOfAdventurer, String adventurersFearString, int expected) {
        Assertions.assertEquals(expected, new Daily1(amountOfAdventurer, adventurersFearString).solution());
    }
}