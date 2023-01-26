package greedy;

import static utils.StringManager.*;

public class Example4 {
    public static void main(String[] args) {
        System.out.printf("N, K 입력 : ");
        int[] input = parseStringArrayToIntArray(splitBlank(getStringLine()));
        int N = input[0];
        int K = input[1];
        int result = 0;

        while(true) {
            int countMinus1 = N % K;
            result += countMinus1;

            N = N - countMinus1;
            if (N < K) {
                break;
            }

            result += 1;
            N /= K;
        }

        result += N - 1;

        singleResult(result);
    }
}
