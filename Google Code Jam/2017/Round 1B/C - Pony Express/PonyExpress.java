import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

//Accepted for the small and large datasets in Practice Mode
public class PonyExpress {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int c=1; c<=t; c++){
			String[] l = br.readLine().split(" ");
			int n = Integer.parseInt(l[0]);
			int q = Integer.parseInt(l[1]);

			int[] endurance = new int[n];
			int[] speed = new int[n];
			for(int i=0; i<n; i++){
				l = br.readLine().split(" ");
				int e = Integer.parseInt(l[0]);
				int s = Integer.parseInt(l[1]);
				endurance[i] = e;
				speed[i] = s;
			}

			long[][] g = new long[n][n];
			for(int i=0; i<n; i++){
				l = br.readLine().split(" ");
				for(int j=0; j<n; j++){
					long d = Long.parseLong(l[j]);
					if(i == j){
						g[i][j] = 0;
					}else if(d == -1){
						g[i][j] = Long.MAX_VALUE;
					}else{
						g[i][j] = d;
					}
				}
			}

			//Floyd-Warshall on the original graph
			long[][] A = new long[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					A[i][j] = g[i][j];
				}
			}

			for(int k=0; k<n; k++){
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						long option1 = A[i][j];
						long option2;
						if(A[i][k] == Long.MAX_VALUE || A[k][j] == Long.MAX_VALUE){
							option2 = Long.MAX_VALUE;
						}else{
							option2 = A[i][k] + A[k][j];
						}
						A[i][j] = Math.min(option1, option2);
					}
				}
			}

			//Build G'
			double[][] gprime = new double[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(A[i][j] <= endurance[i]){
						gprime[i][j] = (double) A[i][j] / (double) speed[i];
					}else{
						gprime[i][j] = Long.MAX_VALUE;
					}
				}
			}

			//Floyd-Warshall on G'
			double[][] B = new double[n][n];
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					B[i][j] = gprime[i][j];
				}
			}

			for(int k=0; k<n; k++){
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						double option1 = B[i][j];
						double option2;
						if(B[i][k] == Long.MAX_VALUE || B[k][j] == Long.MAX_VALUE){
							option2 = Long.MAX_VALUE;
						}else{
							option2 = B[i][k] + B[k][j];
						}
						B[i][j] = Math.min(option1, option2);
					}
				}
			}

			//Answer queries
			System.out.print("Case #" + c + ":");
			for(int i=0; i<q; i++){
				l = br.readLine().split(" ");
				int u = Integer.parseInt(l[0]) - 1;
				int v = Integer.parseInt(l[1]) - 1;
				System.out.format(Locale.US, " %.6f", B[u][v]);
			}
			System.out.println();
		}
	}

}
