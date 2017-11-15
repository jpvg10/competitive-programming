import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		char[] s = sc.nextLine().toCharArray();

		int n = s.length;

		int[] aCountBefore = new int[n+2];
		int[] bBestBefore = new int[n+2];
		int[] aCountAfter = new int[n+2];
		int[] bBestAfter = new int[n+2];

		for(int i=1; i<=n; i++) {
			if(s[i-1] == 'a') {
				aCountBefore[i] = aCountBefore[i-1] + 1;
				bBestBefore[i] = bBestBefore[i-1];
			}else {
				aCountBefore[i] = aCountBefore[i-1];
				bBestBefore[i] = Integer.max(aCountBefore[i]+1, bBestBefore[i-1]+1);
			}
		}

		for(int i=n; i>=1; i--) {
			if(s[i-1] == 'a') {
				aCountAfter[i] = aCountAfter[i+1] + 1;
				bBestAfter[i] = bBestAfter[i+1];
			}else {
				aCountAfter[i] = aCountAfter[i+1];
				bBestAfter[i] = Integer.max(aCountAfter[i]+1, bBestAfter[i+1]+1);
			}
		}

		int ans = -1;

		for(int i=0; i<=n; i++) {
			int bestBefore = Integer.max(aCountBefore[i], bBestBefore[i]);
			int bestAfter = Integer.max(aCountAfter[i+1], bBestAfter[i+1]);
			ans = Integer.max(ans, bestBefore + bestAfter);
		}

		System.out.println(ans);

		sc.close();
	}

}
