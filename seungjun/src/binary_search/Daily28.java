package binary_search;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Daily28 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int arrSize = Integer.parseInt(br.readLine());
        int[] arr = new int[arrSize];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < arrSize; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(binarySearch(arr));
    }

    private static int binarySearch(int[] arr) {
        int front = 0;
        int rear = arr.length - 1;

        while(front <= rear) {
            int mid = (front + rear) / 2;

            if (arr[mid] == mid) {
                return arr[mid];
            }

            if (arr[mid] < mid) {
                front = mid + 1;
            }

            if (arr[mid] > mid) {
                rear = mid - 1;
            }
        }

        return -1;
    }
}
