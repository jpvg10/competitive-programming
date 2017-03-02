import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	static ArrayList<Integer> primes;

	public static void main(String[] args) throws IOException{
		primes = sieve(65535);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while((s = br.readLine()) != null){
			int n = Integer.parseInt(s);
			if(n == 0) break;

			LinkedList<Integer> factors;

			if(n < 0){
				factors = factor(-1*n);
				factors.addFirst(-1);
			}else{
				factors = factor(n);
			}

			System.out.print(n + " = ");

			boolean first = true;

			for(int f : factors){
				if(!first){
					System.out.print(" x " + f);
				}else{
					System.out.print(f);
					first = false;
				}
			}

			System.out.println();
		}
	}

	public static ArrayList<Integer> sieve(int n){
		boolean marked[] = new boolean[n+1];
		ArrayList<Integer> primes = new ArrayList<Integer>();

		for(int i=2; i<=n; i++){
			if(!marked[i]){
				primes.add(i);
				int j = 2*i;
				while(j <= n){
					marked[j] = true;
					j = j+i;
				}
			}
		}

		return primes;
	}

	public static LinkedList<Integer> factor(int n){
		LinkedList<Integer> primeFactors = new LinkedList<Integer>();
		int s = (int) Math.ceil(Math.sqrt(n));

		for(int p: primes){
			if(p > s) break;
			while(n % p == 0){
				n = n/p;
				primeFactors.add(p);
			}
		}

		if(n > 1){
			primeFactors.add(n);
		}

		return primeFactors;
	}
}
