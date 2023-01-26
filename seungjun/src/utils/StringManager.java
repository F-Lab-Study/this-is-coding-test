package utils;

import java.util.Arrays;
import java.util.Scanner;

public class StringManager {
    private static final Scanner scanner = new Scanner(System.in);

    public static int[] parseStringArrayToIntArray(String[] value) {
        try {
            return Arrays.stream(value).mapToInt(Integer::parseInt).toArray();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String getStringLine() {
        return scanner.nextLine();
    }

    public static int getSingleInt() {
        return scanner.nextInt();
    }

    public static String[] splitBlank(String value) {
        return value.split("\\s+");
    }

    public static void singleResult(Object value) {
        System.out.println("결과 : " + value);
    }
}
