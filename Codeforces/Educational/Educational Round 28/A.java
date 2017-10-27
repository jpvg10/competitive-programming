import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] games = new int[n];
		for(int i=0; i<n; i++) {
			games[i] = sc.nextInt();
		}

		int[] zerosBefore = new int[n+1];
		int[] onesAfter = new int[n+1];

		for(int i=1; i<=n; i++) {
			if(games[i-1] == 0) {
				zerosBefore[i] = zerosBefore[i-1] + 1;
			}else {
				zerosBefore[i] = zerosBefore[i-1];
			}
		}

		for(int i=n-1; i>=0; i--) {
			if(games[i] == 1) {
				onesAfter[i] = onesAfter[i+1] + 1;
			}else {
				onesAfter[i] = onesAfter[i+1];
			}
		}

		int max = -1;
		for(int i=0; i<n+1; i++) {
			if(zerosBefore[i] + onesAfter[i] > max) {
				max = zerosBefore[i] + onesAfter[i];
			}
		}

		System.out.println(max);

		sc.close();
	}
}
