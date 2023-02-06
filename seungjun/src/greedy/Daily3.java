package greedy;

public class Daily3 {
    private String input;
    private int groupZeroCount = 0;
    private int groupOneCount = 0;

    public Daily3(String input) {
        this.input = validateInput(input);
    }

    private String validateInput(String input) {
        if (input.length() > 1000000) {
            throw new RuntimeException("입력값 범위 초과!");
        }

        return input;
    }

    public int solution() {
        char preNumber = input.charAt(0);
        for (int i = 1; i < input.length(); i++) {
            if (preNumber != input.charAt(i)) {
                count(preNumber);

                preNumber = input.charAt(i);
            }
        }

        count(preNumber);

        return groupZeroCount <= groupOneCount ? groupZeroCount : groupOneCount;
    }

    private void count(char preNumber) {
        if (preNumber == '0') {
            groupZeroCount++;
        } else {
            groupOneCount++;
        }
    }
}
