package greedy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class Daily2Test {
    @DisplayName("입력 조건 테스트")
    @ParameterizedTest
    @ValueSource(strings = { "", "56098347589024570328753877" })
    void 입력_조건_테스트(String input) {
        Assertions.assertThrows(RuntimeException.class, () -> new Daily2().solution(input));
    }

    @DisplayName("곱하기 혹은 더하기 연산 테스트")
    @ParameterizedTest
    @CsvSource(value = { "02984:576", "567:210" }, delimiter = ':')
    void 곱하기_혹은_더하기(String input, int expected) {
        Assertions.assertEquals(expected, new Daily2().solution(input));
    }
}
