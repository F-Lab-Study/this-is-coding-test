package implementation;

import java.util.ArrayList;
import java.util.List;

public class Example1 {
    private int[] coordinate = { 1, 1 };
    private int coordinateSize;
    private List<Character> commendList = new ArrayList<>();

    public Example1(int coordinateSize, String commend) {
        this.coordinateSize = coordinateSize;
        initialCommendList(commend);
    }

    private void initialCommendList(String commend) {
        for(Character c : commend.toCharArray()) {
            if (c != ' ') {
                commendList.add(c);
            }
        }
    }

    public String solution() {
        for(Character c : commendList) {
            switch (c) {
                case 'L':
                    moveLeft();
                    break;
                case 'R':
                    moveRight();
                    break;
                case 'U':
                    moveUp();
                    break;
                case 'D':
                    moveDown();
                    break;
            }
            System.out.println(String.format("%d %d", coordinate[0], coordinate[1]));
        }

        return String.format("%d %d", coordinate[0], coordinate[1]);
    }

    private void moveLeft() {
        if (coordinate[1] - 1 > 1) {
            coordinate[1]--;
        }
    }

    private void moveRight() {
        if (coordinate[1] + 1 < coordinateSize) {
            coordinate[1]++;
        }
    }

    private void moveUp() {
        if (coordinate[0] - 1 > 1) {
            coordinate[0]--;
        }
    }

    private void moveDown() {
        if (coordinate[0] + 1 < coordinateSize) {
            coordinate[0]++;
        }
    }
}
