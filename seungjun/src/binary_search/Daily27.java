package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Daily27 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arrSize = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] intArr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            intArr[i] = Integer.parseInt(st.nextToken());
        }

        int firstIndex = upperBound(intArr, target);
        if (intArr[firstIndex] != target) {
            System.out.println(-1);
        } else {
            System.out.println(upperBound(intArr, target) - lowerBound(intArr, target));
        }
    }

    private static int lowerBound(int[] intArr, int target) {
        int front = 0;
        int rear = intArr.length - 1;

        while(front < rear) {
            int mid = (front + rear) / 2;

            if (intArr[mid] >= target) {
                rear = mid;
            } else {
                front = mid + 1;
            }
        }

        return rear;
    }

    private static int upperBound(int[] intArr, int target) {
        int front = 0;
        int rear = intArr.length - 1;

        while(front < rear) {
            int mid = (front + rear) / 2;

            if (intArr[mid] > target) {
                rear = mid;
            } else {
                front = mid + 1;
            }
        }

        return rear;
    }
}
