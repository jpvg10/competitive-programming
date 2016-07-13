import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static LinkedList<Integer> topoSort;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l = br.readLine()) != null){
			String s[] = l.split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);

			if(n == 0 && m == 0) break;

			g = new ArrayList[n];
			for(int i=0; i<n; i++){
				g[i] = new ArrayList<Integer>();
			}

			seen = new boolean[n];
			topoSort = new LinkedList<Integer>();

			for(int i=0; i<m; i++){
				s = br.readLine().split(" ");
				int u = Integer.parseInt(s[0]) - 1;
				int v = Integer.parseInt(s[1]) - 1;
				g[u].add(v);
			}

			for(int u = 0; u<n; u++){
				if(!seen[u])
					dfs(u);
			}

			System.out.print((topoSort.poll()+1));
			while(!topoSort.isEmpty()){
				System.out.print(" " + (topoSort.poll()+1));
			}

			System.out.println();
		}
	}

	private static void dfs(int u) {
		seen[u] = true;
		int adyLen = g[u].size();
		for(int i=0; i<adyLen; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				dfs(v);
			}
		}
		topoSort.addFirst(u);
	}

}
