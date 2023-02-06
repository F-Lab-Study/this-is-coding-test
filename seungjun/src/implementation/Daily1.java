package implementation;

import java.util.ArrayList;
import java.util.List;

public class Daily1 {
    private List<Integer> socreList = new ArrayList<>();
    private boolean state = false;

    public Daily1(String scoreString) {
        initialScoreList(scoreString);
    }

    private void initialScoreList(String scoreString) {
        int middleIdx = scoreString.length() / 2;
        int scoreLeft = 0;
        int scoreRight = 0;

        for (int i = 0; i <scoreString.length(); i++) {
            if (i < middleIdx) {
                scoreLeft += Character.digit(scoreString.charAt(i), 10);
            } else {
                scoreRight += Character.digit(scoreString.charAt(i), 10);
            }
        }

        state = scoreLeft == scoreRight;
    }

    public String luckState() {
        return state ? "LUCKY" : "READY";
    }
}
