package greedy;

import static utils.StringManager.parseStringArrayToIntArray;
import static utils.StringManager.splitBlank;

public class Daily5 {
    private int[] input1;
    private int[] input2;

    public Daily5(String input1, String input2) {
        this.input1 = parseStringArrayToIntArray(splitBlank(input1));
        this.input2 = parseStringArrayToIntArray(splitBlank(input2));
    }

    public int solution() {
        int count = 0;
        for (int i = 0; i < input2.length - 1; i++) {
            for (int j = i + 1; j < input2.length; j++) {
                if (input2[i] != input2[j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
