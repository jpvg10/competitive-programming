import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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

		String line = br.readLine();
		while(!line.equals("0 0")){
			HashMap<String, Integer> names = new HashMap<String, Integer>();
			int count = 0;

			String s[] = line.split(" ");
			int p = Integer.parseInt(s[0]);
			int t = Integer.parseInt(s[1]);

			seen = new boolean[p];
			stackMember = new boolean[p];
			disc = new int[p];
			low = new int[p];
			scc = new int[p];
			st = new Stack<Integer>();
			time = 0;
			component = 0;
			g = new ArrayList[p];
			for(int i=0; i<p; i++){
				g[i] = new ArrayList<Integer>();
			}

			for(int i=0; i<p; i++){
				String z = br.readLine();
				names.put(z, count);
				count++;
			}

			for(int i=0; i<t; i++){
				String a = br.readLine();
				String b = br.readLine();
				int x = names.get(a);
				int y = names.get(b);
				g[x].add(y);
			}

			for(int u=0; u<p; u++){
				if(!seen[u]){
					tarjan(u);
				}
			}

			System.out.println(component);

			line = br.readLine();
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
