import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> primes;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int numberFactors[] = new int[1000001];
		int factorialFactors[] = new int[1000001];
		primes = sieve(1000);

		numberFactors[2] = 1;
		factorialFactors[2] = 1;

		for(int i=3; i<=1000000; i++){
			numberFactors[i] = factors(i);
			factorialFactors[i] = factorialFactors[i-1] + numberFactors[i];
		}

		String l;
		while((l = br.readLine()) != null){
			int n = Integer.parseInt(l);
			System.out.println(factorialFactors[n]);
		}
	}

	public static ArrayList<Integer> sieve(int n){
		boolean marked[] = new boolean[n+1];
		ArrayList<Integer> primes = new ArrayList<Integer>();

		for(int i=2; i<=n; i++){
			if(!marked[i]){
				primes.add(i);
				int j = i*i;
				while(j <= n){
					marked[j] = true;
					j = j+i;
				}
			}
		}

		return primes;
	}

	public static int factors(int n){
		int s = (int) Math.ceil(Math.sqrt(n));
		int f = 0;

		for(int p: primes){
			if(p > s) break;
			while(n % p == 0){
				n = n/p;
				f++;
			}
		}

		if(n > 1){
			f++;
		}

		return f;
	}

}
