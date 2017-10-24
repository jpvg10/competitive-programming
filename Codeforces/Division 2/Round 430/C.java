import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class C {
	
	static ArrayList<Integer> g[];
	static boolean seen[];
	static int a[];
	static int beauty[];
	static int count[];
	static ArrayList<Integer> divisors;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		seen = new boolean[n];
		a = new int[n];
		beauty = new int[n];
		divisors = new ArrayList<Integer>();
		g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<Integer>();
		}
		
		String[] line = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(line[i]);
		}
			
		for(int i=0; i<n-1; i++) {
			line = br.readLine().split(" ");
			int x = Integer.parseInt(line[0]) - 1;
			int y = Integer.parseInt(line[1]) - 1;
			g[x].add(y);
			g[y].add(x);
		}		
		
		int t = a[0];
		a[0] = 0;
		dfs(0);
		a[0] = t;
		seen = new boolean[n];
		
		int i = 1;
		while(i*i <= a[0]) {
			if(a[0] % i == 0) {
				divisors.add(i);
				divisors.add(a[0]/i);
			}
			if(i*i == a[0]) divisors.remove(divisors.size() - 1);
			i++;
		}
		Collections.sort(divisors);
		count = new int[divisors.size()];
			
		dfs2(0, 0);
		
		for(int j=0; j<n; j++) {
			System.out.print(beauty[j]);
			if(j < n-1) System.out.print(" ");
		}			
	}
	
	public static int gcd(int a, int b){
		while(b != 0){
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
	
	private static void dfs(int u){
		seen[u] = true;
		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				beauty[v] = gcd(beauty[u], a[v]);
				dfs(v);
			}
		}
	}
	
	private static void dfs2(int u, int depth){
		seen[u] = true;
		
		for(int i=0; i<divisors.size(); i++) {
			if(a[u] % divisors.get(i) == 0) {
				count[i]++;
			}
			if(count[i] >= depth) {
				beauty[u] = Integer.max(beauty[u], divisors.get(i));
			}
		}
		
		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				dfs2(v, depth + 1);
			}
		}
		
		for(int i=0; i<divisors.size(); i++) {
			if(a[u] % divisors.get(i) == 0) {
				count[i]--;
			}
		}
	}
}
