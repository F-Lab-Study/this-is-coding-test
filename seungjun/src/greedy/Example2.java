package greedy;

import java.util.Arrays;

import static utils.StringManager.*;

public class Example2 {
    public static void main(String[] args) {
        System.out.printf("N, M, K 입력 : ");
        int[] input1 = parseStringArrayToIntArray(splitBlank(getStringLine()));
        int N = input1[0];
        int M = input1[1];
        int K = input1[2];

        System.out.printf("숫자 배열 입력 : ");
        int[] input2 = parseStringArrayToIntArray(splitBlank(getStringLine()));
        if (input2.length != N) {
            throw new RuntimeException("N개의 숫자 배열을 입력하세요!");
        }

        input2 = Arrays.stream(input2).sorted().toArray();
        int firstMax = input2[N - 1];
        int secondMax = input2[N - 2];

        int count = ((int) (M / (K + 1))) * K + M % (K + 1);
        int result = (count * firstMax) + (M - count) * secondMax;

        singleResult(result);
    }
}
