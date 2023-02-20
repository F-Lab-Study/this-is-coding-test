package sorting.daily25;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Daily25FailFirst {
    public static void main(String[] args) {
        int[] answer = new Daily25FailFirst().solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3});
        Arrays.stream(answer).forEach(System.out::println);
    }

    public int[] solution(int N, int[] stages) {
        List<Integer> stageList = new ArrayList<>();
        for (int s : stages) {
            stageList.add(s);
        }

        Collections.sort(stageList);

        List<StageFailure> stageFailureList = new ArrayList<>();
        int challenger = N + 1;
        int counter = 1;
        int pre = stageList.get(0);
        for (int i = 1; i < stageList.size(); i++) {
            if (pre != stageList.get(i)) {
                System.out.printf("실패 : %d\n", stageList.get(i));
                stageFailureList.add(
                        new StageFailure(pre, counter/challenger)
                );

                pre = stageList.get(i);
                challenger -= counter;
                counter = 0;
            }

            counter++;
        }

        Collections.sort(stageFailureList);

        int[] answer = new int[stageFailureList.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = stageFailureList.get(i).N;
        }

        return answer;
    }

    class StageFailure implements Comparable<StageFailure> {
        int N;
        int div;

        public StageFailure(int N, int div) {
            this.N = N;
            this.div = div;
        }

        @Override
        public int compareTo(StageFailure o) {
            return o.div - this.div;
        }
    }
}
