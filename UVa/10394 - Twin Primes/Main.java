import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Integer> primes = sieve(20000000);
		ArrayList<Integer> twinPrimes = new ArrayList<Integer>();

		for(int i=1; i<primes.size(); i++){
			if(primes.get(i)-primes.get(i-1) == 2){
				twinPrimes.add(i-1);
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l;
		while((l = br.readLine()) != null){
			int s = Integer.parseInt(l) - 1;
			int t = twinPrimes.get(s);
			System.out.println("(" + primes.get(t) + ", " + primes.get(t+1) + ")");
		}

	}

	public static ArrayList<Integer> sieve(int n){
		boolean marked[] = new boolean[n+1];
		marked[0] = true;
		marked[1] = true;
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

}
