package baekjoon.q1269;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String inputString = scanner.nextLine();
        int[] inputLength = Arrays.stream(inputString.split("\\s+")).mapToInt(Integer::parseInt).toArray();

        String[] setA = scanner.nextLine().split("\\s+");
        if (inputLength[0] != setA.length) {
            throw new IllegalArgumentException("조건에 부합하지 않습니다.");
        }

        String[] setB = scanner.nextLine().split("\\s+");
        if (inputLength[1] != setB.length) {
            throw new IllegalArgumentException("조건에 부합하지 않습니다.");
        }
        Set<String> stringSet = new HashSet<>(Arrays.asList(setB));

        int count = 0;
        for (String iA : setA) {
            if (stringSet.contains(iA)) {
                count++;
            }
        }

        System.out.println((setA.length - count) + (setB.length - count));
    }
}
