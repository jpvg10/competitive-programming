import java.util.Arrays;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int m = sc.nextInt();

		int costOfTask = 0;
		int[] t = new int[k];
		for(int i=0; i<k; i++) {
			t[i] = sc.nextInt();
			costOfTask += t[i];
		}
		Arrays.sort(t);

		int maxPoints = -1;
		int complete = 0;
		while(complete <=n && complete*costOfTask <= m ) {
			int points = complete*(k+1);
			int remaining = m - complete*costOfTask;

			int j = 0;
			int count = 0;
			while(complete < n && remaining > 0 && j<k && t[j] <= remaining) {
				remaining -= t[j];
				count++;
				points++;
				if(count == n-complete) {
					count = 0;
					j++;
				}
			}
			maxPoints = Integer.max(maxPoints, points);

			complete++;
		}

		System.out.println(maxPoints);

		sc.close();
	}

}
