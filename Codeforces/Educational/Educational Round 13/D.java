import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D {

	static int mod = 1000000007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] in = br.readLine().split(" ");

		int a = Integer.parseInt(in[0]);
		int b = Integer.parseInt(in[1]);
		long n = Long.parseLong(in[2]);
		int x = Integer.parseInt(in[3]);

		long[][] M = {{a, b}, {0,1}};
		long[][] X = {{x}, {1}};

		long[][] R = multiply(power(M, n), X);

		System.out.println(R[0][0]);
	}

	public static long[][] multiply(long[][] A, long[][] B){
		int m = A.length;
		int n = A[0].length;
		int p = B[0].length;

		long[][] C = new long[m][p];

		for(int i=0; i<m; i++) {
			for(int j=0; j<p; j++) {
				long current = 0;
				for(int k=0; k<n; k++) {
					current = (current + (A[i][k]*B[k][j]) % mod) % mod;
				}
				C[i][j] = current;
			}
		}

		return C;
	}

	public static long[][] power(long[][] M, long n){
		if(n == 1) {
			return M;
		}

		long[][] T = power(M, n/2);

		if(n%2 == 0) {
			return multiply(T, T);
		}else {
			return multiply(M, multiply(T, T));
		}
	}
}
