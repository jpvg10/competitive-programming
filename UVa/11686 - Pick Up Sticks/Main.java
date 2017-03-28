import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	static ArrayList<Integer> g[];
	static int seen[];
	static LinkedList<Integer> topoSort;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l = br.readLine()) != null){
			String s[] = l.split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);

			if(n == 0 && m == 0) break;

			seen = new int[n];
			topoSort = new LinkedList<Integer>();

			g = new ArrayList[n];
			for(int i = 0; i < n; i++){
				g[i] = new ArrayList<Integer>();
			}

			for(int i=0; i<m; i++){
				s = br.readLine().split(" ");
				int a = Integer.parseInt(s[0]) - 1;
				int b = Integer.parseInt(s[1]) - 1;
				g[a].add(b);
			}

			boolean sinCiclo = true;
			for(int u=0; u<n; u++){
				if(seen[u] == 0){
					sinCiclo = sinCiclo && topoDfs(u);
				}
			}

			if(sinCiclo){
				for(int u : topoSort){
					System.out.println(u+1);
				}
			}else{
				System.out.println("IMPOSSIBLE");
			}
		}
	}

	private static boolean topoDfs(int u){
		seen[u] = 1;
		int len = g[u].size();
		boolean sinCiclo = true;
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(seen[v] == 0){
				sinCiclo = sinCiclo && topoDfs(v);
			}else if(seen[v] == 1){
				sinCiclo = false;
			}
		}
		seen[u] = 2;
		topoSort.addFirst(u);
		return sinCiclo;
	}

}
