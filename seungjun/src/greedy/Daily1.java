package greedy;

import java.util.Arrays;

import static utils.StringManager.*;

public class Daily1 {
    private int groupCount = 0;
    private final int amountOfAdventurer;
    private final int[] adventurersFearArray;

    public Daily1(int amountOfAdventurer, String adventurersFearString) {
        this.amountOfAdventurer = amountOfAdventurer;
        adventurersFearArray = sortArray(parseStringArrayToIntArray(splitBlank(adventurersFearString)));
    }

    public int solution() {
        checkAdventurersFearArrayLength();
        makeGroup();

        return groupCount;
    }

    private void checkAdventurersFearArrayLength() {
        if (notSameAmountOfAdventurer()) {
            throw new RuntimeException("amountOfAdventurer 만큼의 숫자 배열을 입력하세요!");
        }

        if (isOverSizeFearValue()) {
            throw new RuntimeException("공포도 값은 amountOfAdventurer를 넘을 수 없습니다!");
        }
    }

    private int[] sortArray(int[] adventurersFearArray) {
        return Arrays.stream(adventurersFearArray).sorted().toArray();
    }

    private void makeGroup() {
        for (int i = 0; i < amountOfAdventurer; i += adventurersFearArray[i]) {
            countGroup(i);
        }
    }

    private boolean notSameAmountOfAdventurer() {
        return adventurersFearArray.length != amountOfAdventurer;
    }

    private boolean isOverSizeFearValue() {
        return Arrays.stream(adventurersFearArray).anyMatch(af -> af > amountOfAdventurer);
    }

    private void countGroup(int i) {
        if (canMakeGroup(i)) {
            groupCount++;
        }
    }

    private boolean canMakeGroup(int i) {
        return i + adventurersFearArray[i] < amountOfAdventurer;
    }
}
