package sorting.q10989;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] counter = new int[10001];
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int inputSize = Integer.parseInt(br.readLine());

        for (int i = 1; i <= inputSize; i++) {
            counter[Integer.parseInt(br.readLine())]++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < counter.length; i++) {
            if (counter[i] == 0) {
                continue;
            }

            for (int j = 0; j < counter[i]; j++) {
                stringBuilder.append(i).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }
}
