import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	public static void main(String[] args) throws IOException {
		ArrayList<Integer> primes = sieve(1000000);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++){
			String s[] = br.readLine().split(" ");
			int l = Integer.parseInt(s[0]);
			int u = Integer.parseInt(s[1]);

			HashMap<Integer, Integer> distances = new HashMap<Integer, Integer>();
			int current = -1;
			int prev = -1;

			for(int j=0; j<primes.size(); j++){
				if(primes.get(j) >= l && primes.get(j) <= u){
					current = primes.get(j);
					if (current != -1 && prev != -1) {
						int d = current - prev;
						if (distances.containsKey(d)) {
							distances.put(d, distances.get(d) + 1);
						} else {
							distances.put(d, 1);
						}
					}
					prev = current;
				}else if(primes.get(j) > u){
					break;
				}
			}

			int max = -1;
			int ans = -1;
			boolean tie = false;

			for(Entry<Integer, Integer> e : distances.entrySet()){
				if(e.getValue() > max){
					max = e.getValue();
					ans = e.getKey();
					tie = false;
				}else if(e.getValue() == max){
					tie = true;
				}
			}

			if(tie || ans == -1){
				System.out.println("No jumping champion");
			}else{
				System.out.println("The jumping champion is " + ans);
			}
		}
	}

	public static ArrayList<Integer> sieve(int n){
		boolean marked[] = new boolean[n + 1];
		marked[0] = true;
		marked[1] = true;
		ArrayList<Integer> primes = new ArrayList<Integer>();

		for(int i = 2; i <= n; i++){
			if(!marked[i]){
				primes.add(i);
				int j = 2 * i;
				while(j <= n){
					marked[j] = true;
					j = j + i;
				}
			}
		}

		return primes;
	}
}
