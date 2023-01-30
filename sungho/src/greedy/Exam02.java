package greedy;

import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Exam02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();

		Set<Integer> integers = new HashSet<>();

		for (int i = 0; i < n; i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < m; j++) {
				int x = sc.nextInt();
				integers.add(min = Math.min(min, x));
			}
		}
		System.out.println(Collections.max(integers));
	}
}
