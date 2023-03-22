package dynamic_programming;

import java.util.Scanner;

public class Example1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int[] dp = new int[x + 1];

        for (int i = 2; i < x + 1; i++) {
            // i - 1은 무조건 하는 연산이므로 미리 구하여 dp[i]에 1회를 카운팅한다.
            dp[i] = dp[i - 1] + 1;

            if (i % 2 == 0) {
                // i - 1와 횟수와 dp[i / 2] + 1들 중 횟수가 더 적은 값을 dp[i]에 저장한다.
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            // 여기서부터는 위 과정에서 연산된 결과하고 비교한다.
            // 위 결과와 dp[i / 3] + 1들 중 횟수가 더 적은 값을 dp[i]에 저장한다.
            if (i % 3 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 3] + 1);
            }

            // 위 결과와 dp[i / 5] + 1들 중 횟수가 더 적은 값을 dp[i]에 저장한다.
            if (i % 5 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 5] + 1);
            }
        }

        // dp[x]에는 최소 횟수가 저장된다.
    }
}
