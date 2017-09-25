import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

//Problema de la competencia 03 de la RPC 2017
public class Main {

	static int smallestFactor[];
	static ArrayList<Integer> primes;

	public static void main(String args[]) throws IOException{
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));

		int t=Integer.parseInt(bf.readLine());

		cribaFactores(1000000);

		for (int i = 0; i < t; i++) {
			long n = Long.parseLong(bf.readLine());

			HashMap<Long, Integer> factores = factorizar(n);

			long sigma = 1;
			for(Entry<Long,Integer> e : factores.entrySet()){
				sigma *= productoria(e.getKey(), e.getValue());
			}
			sigma = sigma-n;

			if(sigma < n){
				bw.write("deficient\n");
			}else if(sigma == n){
				bw.write("perfect\n");
			}else{
				bw.write("abundant\n");
			}
		}

		bw.flush();
	}

	public static long productoria(long base, int potencia){
		return (long)((Math.pow(base, (potencia+1))-1)/(base-1));
	}

	public static void cribaFactores(int n){
		smallestFactor = new int[n+1];
		Arrays.fill(smallestFactor, -1);
		primes = new ArrayList<Integer>();

		for(int i=2; i<=n; i++){
			if(smallestFactor[i] == -1){
				primes.add(i);
				int j = 2*i;
				while(j <= n){
					if(smallestFactor[j] == -1){
						smallestFactor[j] = i;
					}
					j = j+i;
				}
			}
		}
	}

	public static HashMap<Long, Integer> factorizar(long n){
		HashMap<Long, Integer> primeFactors = new HashMap<Long, Integer>();

		if(n >= smallestFactor.length){
			for(int p : primes){
				if(n % p == 0){
					int count = 0;
					while(n % p == 0){
						n = n/p;
						count++;
					}
					primeFactors.put((long)p, count);
				}
				if(n < smallestFactor.length) break;
			}
			if(n >= smallestFactor.length){
				primeFactors.put(n, 1);
				return primeFactors;
			}
		}

		int m = (int) n;

		while(m > 1){
			int f = smallestFactor[m];
			if(f == -1){
				f = m;
			}
			if(primeFactors.containsKey((long)f)){
				primeFactors.put((long)f, primeFactors.get((long)f)+1);
			}else{
				primeFactors.put((long)f, 1);
			}
			m = m / f;
		}

		return primeFactors;
	}

}
