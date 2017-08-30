import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		for(int t=0; t<n; t++) {
			int m = Integer.parseInt(br.readLine());
			int values[] = new int[m];
			int weights[] = new int[m];
			int total = 0;

			String[] l = br.readLine().split(" ");
			for(int i=0; i<m; i++) {
				values[i] = Integer.parseInt(l[i]);
				weights[i] = values[i];
				total += values[i];
			}

			int W = total / 2;
			int A[][] = new int[m+1][W+1];

			// Knapsack
			for (int i=1; i<=m; i++) {
				for (int x=0; x<=W; x++) {
					if (weights[i-1] > x) {
						A[i][x] = A[i-1][x];
					} else {
						int p = A[i-1][x];
						int q = A[i-1][x-weights[i-1]] + values[i-1];
						A[i][x] = (p > q) ? p : q;
					}
				}
			}


			int coinsA = A[m][W];
			int coinsB = total - coinsA;

			System.out.println(Math.abs(coinsB - coinsA));
		}
	}

}
