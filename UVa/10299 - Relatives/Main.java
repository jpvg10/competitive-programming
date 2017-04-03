import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	
	static int menorFactor[];
	static ArrayList<Integer> primos;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		cribaFactores(100000);
		
		String l;
		while((l = br.readLine()) != null){
			int n = Integer.parseInt(l);
			
			if(n == 0) break;
			
			HashMap<Integer, Integer> factores = factorizar(n);
			
			int totient = 1;
			
			for(Entry<Integer, Integer> e : factores.entrySet()){
				totient *= (e.getKey() - 1) * (int)Math.pow(e.getKey(), e.getValue()-1);
			}
			
			System.out.println(totient);
		}
	}
	
	public static void cribaFactores(int n){
		menorFactor = new int[n+1];
		Arrays.fill(menorFactor, -1);
		primos = new ArrayList<Integer>();
		
		for(int i=2; i<=n; i++){
			if(menorFactor[i] == -1){
				primos.add(i);
				int j = 2*i;
				while(j <= n){
					if(menorFactor[j] == -1){
						menorFactor[j] = i;
					}						
					j = j+i;
				}
			}
		}
	}
	
	public static HashMap<Integer, Integer> factorizar(int n){
		HashMap<Integer, Integer> factores = new HashMap<Integer, Integer>();	
		
		if(n == 1){
			factores.put(1, 1);
			return factores;
		}
				
		if(n >= menorFactor.length){			
			for(int p : primos){
				if(n % p == 0){
					int count = 0;
					while(n % p == 0){
						n = n/p;
						count++;
					}
					factores.put(p, count);
				}
				if(n < menorFactor.length) break;
			}
			if(n >= menorFactor.length){
				factores.put(n, 1);
				return factores;
			}			
		}
				
		while(n > 1){
			int f = menorFactor[n];
			if(f == -1){
				f = n;
			}
			if(factores.containsKey(f)){
				factores.put(f, factores.get(f)+1);
			}else{
				factores.put(f, 1);
			}
			n = n / f;
		}		
		
		return factores;
	}

}
