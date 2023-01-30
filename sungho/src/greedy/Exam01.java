package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Exam01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//배열의 크기
		int n = sc.nextInt();
		//숫자가 더해지는 횟수
		int m = sc.nextInt();
		//최대로 더해야할 횟수
		int k = sc.nextInt();

		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);

		//가장큰수
		int first = arr[n - 1];
		//두번째로 큰수
		int second = arr[n - 2];
		int sum = 0;

		while (true) {
			//가장큰수 덧셈
			for (int i = 0; i < k; i++) {
				if (m == 0) {
					break;
				}
				sum += first;
				m--;
			}
			if (m == 0) {
				break;
			}
			sum += second;
			m--;
		}
		System.out.println(sum);
	}

}
