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
	static Stack<Integer> st;
	static int time;
	static int component;
	static int scc[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++){
			String s;
			while((s = br.readLine()) != null){
				String l[] = s.split(" ");
				int n = Integer.parseInt(l[0]);
				int m = Integer.parseInt(l[1]);

				seen = new boolean[n];
				stackMember = new boolean[n];
				disc = new int[n];
				low = new int[n];
				scc = new int[n];
				st = new Stack<Integer>();
				time = 0;
				component = 0;

				g = new ArrayList[n];
				for(int j = 0; j<n; j++){
					g[j] = new ArrayList<Integer>();
				}

				for(int j=0; j<m; j++){
					l = br.readLine().split(" ");
					int x = Integer.parseInt(l[0]) - 1;
					int y = Integer.parseInt(l[1]) - 1;
					g[x].add(y);
				}

				for(int u=0; u<n; u++){
					if(!seen[u]){
						tarjan(u);
					}
				}

				boolean inEdges[] = new boolean[component];

				for(int u=0; u<n; u++){
					for(int v: g[u]){
						if(scc[u] != scc[v]){
							inEdges[scc[v]] = true;
						}
					}
				}

				int byHand = 0;

				for(int j=0; j<inEdges.length; j++){
					if(!inEdges[j]){
						byHand++;
					}
				}

				System.out.println(byHand);
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
