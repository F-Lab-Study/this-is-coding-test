package greedy;

public class Daily2 {
    public int solution(String numberString) {
        validateStringLength(numberString);

        int result = 0;
        for (int i = 0; i < numberString.length(); i++) {
            int number = parseInt(numberString, i);
            if (result == 0 || isZeroOrOne(number)) {
                result += number;
            } else {
                result *= number;
            }
        }

        return result;
    }

    private void validateStringLength(String numberString) {
        if (isCorrectStringLength(numberString)) {
            throw new RuntimeException("문자열의 길이가 조건에 맞지 않습니다!");
        }
    }

    private int parseInt(String numberString, int i) {
        return Character.digit(numberString.charAt(i), 10);
    }

    private boolean isZeroOrOne(int number) {
        return number == 0 || number == 1;
    }

    private static boolean isCorrectStringLength(String numberString) {
        return numberString.length() < 1 || numberString.length() >= 20;
    }
}