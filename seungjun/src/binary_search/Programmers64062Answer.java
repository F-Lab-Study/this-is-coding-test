package binary_search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Programmers64062Answer {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        List<Integer> stoneList = new ArrayList<>();
        for (int s : stones) {
            stoneList.add(s);
        }

        Collections.sort(stoneList);

        System.out.println(lowerBound(stones, stoneList, k));
    }

    private static int lowerBound(int[] stones, List<Integer> stoneList, int k) {
        int front = 0;
        int rear = stoneList.size() - 1;
        while(front < rear) {
            int mid = (front + rear) / 2;

            if (moveCount(stoneList.get(mid), stones, k)) {
                rear = mid;
            } else {
                front = mid + 1;
            }

        }

        return stoneList.get(rear);
    }

    private static boolean moveCount(int midValue, int[] stones, int k) {
        int count = 0;
        for (int s : stones) {
            if (s - midValue <= 0) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) {
                return true;
            }
        }

        return false;
    }
}
