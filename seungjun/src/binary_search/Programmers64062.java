package binary_search;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Programmers64062 {
    public static void main(String[] args) {
        int[] stones = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;

        Set<Integer> stoneSet = new HashSet<>();
        for(int s : stones) {
            stoneSet.add(s);
        }

        PriorityQueue<Integer> stoneQueue = new PriorityQueue<>(stoneSet);

        int count = 0;
        while (!stoneQueue.isEmpty()) {
            int stoneValue = stoneQueue.poll();
            count += stoneValue;

            for (int i = 0; i < stones.length; i++) {
                stones[i] = Math.max((stones[i] - stoneValue), 0);
            }

            int lower = lowerBound(stones, 0, stones.length - 1);
            int upper = upperBound(stones, 0, stones.length - 1);

            if (upper - lower >= k) {
                break;
            }
        }

        System.out.println(count);
    }

    private static int lowerBound(int[] arr, int front, int rear) {
        while(front < rear) {
            int mid = (front + rear) / 2;

            if (arr[mid] >= 0) {
                rear = mid;
            } else {
                front = mid + 1;
            }
        }

        return rear;
    }

    private static int upperBound(int[] arr, int front, int rear) {
        while(front < rear) {
            int mid = (front + rear) / 2;

            if (arr[mid] > 0) {
                rear = mid;
            } else {
                front = mid + 1;
            }
        }

        return rear;
    }
}
