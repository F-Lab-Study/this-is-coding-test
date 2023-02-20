package sorting.daily25;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Daily25FailSecond {
    public static void main(String[] args) {
        for (int i : new Daily25FailSecond().solution(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3})) {
            System.out.println(i);
        }
    }

    public int[] solution(int N, int[] stages) {
        int[] playerByStage = new int[N + 2];
        for (int s : stages) {
            playerByStage[s]++;
        }

        List<StageFailure> stageFailureList = new ArrayList<>();
        int challenger = stages.length;
        for (int i = 1; i <= N; i++) {
            StageFailure stageFailure = new StageFailure(i, (double) playerByStage[i] / challenger);
            stageFailureList.add(stageFailure);

            challenger -= playerByStage[i];
        }

        stageFailureList.sort(Comparator.comparing(StageFailure::getDiv, Comparator.reverseOrder()));

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            answer[i] = stageFailureList.get(i).N;
        }

        return answer;
    }

    static class StageFailure {
        int N;
        double div;

        public StageFailure(int N, double div) {
            this.N = N;
            this.div = div;
        }

        public double getDiv() {
            return div;
        }
    }
}
