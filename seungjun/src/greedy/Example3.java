package greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static utils.StringManager.*;

public class Example3 {
    public static void main(String[] args) {
        System.out.printf("2차원 배열 크기 입력 : ");
        int[] input1 = parseStringArrayToIntArray(splitBlank(getStringLine()));
        int N = input1[0];
        int M = input1[1];

        System.out.println("2차원 배열 입력 : ");
        List<int[]> input2 = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int[] input = parseStringArrayToIntArray(splitBlank(getStringLine()));
            if (input.length != M) {
                throw new RuntimeException("M개의 배열을 입력해야 합니다!");
            }

            input2.add(input);
        }

        int result = 0;
        for (int[] data : input2) {
            int min = Arrays.stream(data).sorted().toArray()[0];
            result = Math.max(result, min);
        }

        singleResult(result);
    }
}
