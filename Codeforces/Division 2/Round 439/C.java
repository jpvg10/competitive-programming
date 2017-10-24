import java.util.Scanner;

public class C {

	static long mod = 998244353;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int max = Integer.max(a, Integer.max(b, c));
		long[] f = factorial(max);
		long[][] C = binomial(max);

		int ab = Integer.min(a, b);
		int bc = Integer.min(b, c);
		int ca = Integer.min(c, a);

		long ans = 1;
		long sum = 0;

		for(int k=0; k<=ab; k++) {
			long current = f[k];
			current =  (current * C[a][k]) % mod;
			current = (current * C[b][k]) % mod;
			sum = (sum + current) % mod;
		}
		ans = (ans * sum) % mod;

		sum = 0;
		for(int k=0; k<=bc; k++) {
			long current = f[k];
			current =  (current * C[b][k]) % mod;
			current = (current * C[c][k]) % mod;
			sum = (sum + current) % mod;
		}
		ans = (ans * sum) % mod;

		sum = 0;
		for(int k=0; k<=ca; k++) {
			long current = f[k];
			current =  (current * C[c][k]) % mod;
			current = (current * C[a][k]) % mod;
			sum = (sum + current) % mod;
		}
		ans = (ans * sum) % mod;

		System.out.println(ans);

		sc.close();
	}

	public static long[] factorial(int n) {
		long[] f = new long[n+1];
		f[0] = 1;
		for(int i=1; i<=n; i++) {
			f[i] = (f[i-1]*i) % mod;
		}
		return f;
	}

	public static long[][] binomial(int n){
		long[][] C = new long[n+1][n+1];

		for(int i=0; i<=n; i++){
			C[i][0] = 1;
			for(int j=1; j<=i; j++){
				C[i][j] = (C[i-1][j-1] + C[i-1][j]) % mod;
			}
		}

		return C;
	}

}
