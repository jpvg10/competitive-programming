import java.util.ArrayList;
import java.util.Scanner;

public class E {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static ArrayList<Integer> component;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		seen = new boolean[n];
		g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<m; i++){
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			g[u].add(v);
			g[v].add(u);
		}

		int cycles = 0;

		for(int u=0; u<n; u++){
			if(!seen[u]){
				component = new ArrayList<Integer>();

				dfs(u);

				boolean isCycle = true;
				for(int v : component){
					if(g[v].size() != 2){
						isCycle = false;
						break;
					}
				}

				if(isCycle){
					cycles++;
				}
			}
		}

		System.out.println(cycles);

		sc.close();
	}

	private static void dfs(int u){
		seen[u] = true;
		component.add(u);
		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				dfs(v);
			}
		}
	}

}
