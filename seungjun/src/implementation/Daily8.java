package implementation;

import java.util.ArrayList;
import java.util.List;

public class Daily8 {
    private int sum = 0;
    private final List<Character> characterList = new ArrayList<>();

    public Daily8(String input) {
        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                sum += Character.digit(c, 10);
            } else {
                characterList.add(c);
            }
        }

        characterList.sort(Character::compareTo);
    }

    public String getResult() {
        StringBuilder stringBuilder = new StringBuilder();
        characterList.forEach(stringBuilder::append);
        return String.format("%s%d", stringBuilder.toString(), sum);
    }
}
