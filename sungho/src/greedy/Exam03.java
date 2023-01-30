package greedy;

import java.util.Scanner;

public class Exam03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		NumberOne numberOne = new NumberOne(sc.nextInt(), sc.nextInt());
		numberOne.solution();
		System.out.println(numberOne.getCount());
	}

	public static class NumberOne {
		private int n;
		private int k;
		private int count;

		public NumberOne(int n, int k) {
			this.n = n;
			this.k = k;
			this.count = 0;
		}

		private void minus() {
			this.n -= 1;
			count++;
		}

		private void division() {
			this.n /= k;
			count++;
		}

		private boolean notDivision() {
			return n % k != 0;
		}

		public int getCount() {
			return count;
		}

		public void solution() {

			while (n >= k) {
				while (notDivision()) {
					minus();
				}
				division();
			}
			while (n > 1) {
				minus();
			}
		}
	}
}
