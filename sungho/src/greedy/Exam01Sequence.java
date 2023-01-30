package greedy;

import java.util.Arrays;
import java.util.Scanner;

public class Exam01Sequence {
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

		int count = (m / (k + 1)) * 3;
		count += m % (k + 1);

		int sum = (count) * first;
		sum += (m - count) * second;
		System.out.println(sum);
	}
}
