import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> primes;
	static boolean marked[];

	public static void main(String[] args) throws IOException{
		sieve(1000000);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while((s = br.readLine()) != null){
			int n = Integer.parseInt(s);
			if(n == 0) break;

			for(int p: primes){
				if(p > n/2) break;
				if(!marked[n-p]){
					System.out.println(n + " = " + p + " + " + (n-p));
					break;
				}
			}
		}
	}

	public static ArrayList<Integer> sieve(int n){
		marked = new boolean[n+1];
		primes = new ArrayList<Integer>();

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
	}
}
