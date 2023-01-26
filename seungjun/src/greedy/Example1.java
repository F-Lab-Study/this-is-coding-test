package greedy;

import static utils.StringManager.*;

public class Example1 {
    public static void main(String[] args) {
        int[] coins = { 500, 100, 50, 10 };
        int input;
        int count = 0;

        System.out.printf("거스름 돈 입력 : ");
        input = getSingleInt();

        for (int coin : coins) {
            int coin_count = input / coin;
            count = coin_count;
            input -= coin_count * coin;
        }

        singleResult(count);
    }
}
