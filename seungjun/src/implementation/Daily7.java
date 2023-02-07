package implementation;

public class Daily7 {
    private boolean state = false;

    public Daily7(String scoreString) {
        initialScoreList(scoreString);
    }

    private void initialScoreList(String scoreString) {
        int middleIdx = scoreString.length() / 2;
        int scoreLeft = 0;
        int scoreRight = 0;

        for (int i = 0; i < middleIdx; i++) {
            scoreLeft += parseInt(scoreString.charAt(i)) - parseInt(scoreString.charAt(i + middleIdx));
        }

        state = scoreLeft == scoreRight;
    }

    private static int parseInt(char value) {
        return Character.digit(value, 10);
    }

    public String luckState() {
        return state ? "LUCKY" : "READY";
    }
}
