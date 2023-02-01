package greedy;

import java.util.Arrays;

import static utils.StringManager.*;

public class Daily1 {
    private static int groupCount = 0;
    private static int amountOfAdventurer;
    private static int[] adventurersFearArray;
    
    public static void main(String[] args) {
        getInputValue();

        solution();
        
        singleResult(groupCount);
    }

    private static void getInputValue() {
        System.out.printf("모험가 수 입력 : ");
        amountOfAdventurer = getSingleInt();

        System.out.printf("모험가별 공포도 입력 : ");
        adventurersFearArray = parseStringArrayToIntArray(splitBlank(getStringLine()));
        if (adventurersFearArray.length != amountOfAdventurer) {
            throw new RuntimeException("amountOfAdventurer 만큼의 숫자 배열을 입력하세요!");
        }
    }

    private static void solution() {
        sortArray();
        makeGroup();
    }

    private static void sortArray() {
        adventurersFearArray = Arrays.stream(adventurersFearArray).sorted().toArray();
    }

    private static void makeGroup() {
        for (int i = 0; i < amountOfAdventurer; i+= adventurersFearArray[i]) {
            countGroup(i);
        }
    }

    private static void countGroup(int i) {
        if (canMakeGroup(i)) {
            groupCount++;
        }
    }

    private static boolean canMakeGroup(int i) {
        return i + adventurersFearArray[i] < amountOfAdventurer;
    }
}
