import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static boolean stackMember[];
	static int disc[];
	static int low[];
	static int scc[];
	static Stack<Integer> st;
	static int time;
	static int component;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while((s = br.readLine()) != null){
			String l[] = s.split(" ");
			int n = Integer.parseInt(l[0]);
			int m = Integer.parseInt(l[1]);

			if(n == 0 && m == 0) break;

			seen = new boolean[n];
			stackMember = new boolean[n];
			disc = new int[n];
			low = new int[n];
			scc = new int[n];
			st = new Stack<Integer>();
			time = 0;
			component = 0;
			g = new ArrayList[n];
			for(int i = 0; i < n; i++){
				g[i] = new ArrayList<Integer>();
			}

			for(int i=0; i<m; i++){
				l = br.readLine().split(" ");
				int v = Integer.parseInt(l[0]) - 1;
				int w = Integer.parseInt(l[1]) - 1;
				int p = Integer.parseInt(l[2]);
				g[v].add(w);
				if(p == 2){
					g[w].add(v);
				}
			}

			for(int u=0; u<n; u++){
				if(!seen[u]){
					tarjan(u);
				}
			}

			if(component == 1){
				System.out.println(1);
			}else{
				System.out.println(0);
			}
		}
	}

	private static void tarjan(int u){
		seen[u] = true;
		st.add(u);
		stackMember[u] = true;
		disc[u] = time;
		low[u] = time;
		time++;

		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				tarjan(v);
				low[u] = Math.min(low[u], low[v]);
			}else if(stackMember[v]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}

		if(low[u] == disc[u]){
			int w;
			do{
				w = st.pop();
				stackMember[w] = false;
				scc[w] = component;
			}while(w != u);
			component++;
		}
	}

}
