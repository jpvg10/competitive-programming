import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean first = true;

		String s;
		while((s = br.readLine()) != null){
			int questions = Integer.parseInt(s);
			if(questions == 0) break;

			if(first){
				first = false;
			}else{
				bw.write("\n");
			}

			int answers[][] = new int[questions][6];
			int count = 0;
			HashMap<String, Integer> labels = new HashMap<String, Integer>();
			HashMap<Integer, String> inverseLabels = new HashMap<Integer, String>();

			for(int i=0; i<questions; i++){
				String l[] = br.readLine().split(" ");
				for(int j=0; j<6; j++){
					if(labels.containsKey(l[j])){
						answers[i][j] = labels.get(l[j]);
					}else{
						answers[i][j] = count;
						labels.put(l[j], count);
						inverseLabels.put(count, l[j]);
						count++;
					}
				}
			}

			int n = labels.size();

			seen = new boolean[n];
			stackMember = new boolean[n];
			disc = new int[n];
			low = new int[n];
			scc = new int[n];
			st = new Stack<Integer>();
			time = 0;
			component = 0;
			g = new ArrayList[n];
			for(int j=0; j<n; j++){
				g[j] = new ArrayList<Integer>();
			}

			for(int i=0; i<questions; i++){
				int chosen = answers[i][5];
				for(int j=0; j<5; j++){
					if(answers[i][j] != chosen){
						g[chosen].add(answers[i][j]);
					}
				}
			}

			for(int u=0; u<n; u++){
				if(!seen[u]){
					tarjan(u);
				}
			}

			String sets[] = new String[component];
			for(int i=0; i<component; i++){
				StringBuilder sb = new StringBuilder();
				for(int j=0; j<n; j++){
					if(scc[j] == i){
						sb.append(inverseLabels.get(j));
					}
				}
				sets[i] = sortString(sb.toString());
			}

			Arrays.sort(sets);

			for(int i=0; i<component; i++){
				char c[] = sets[i].toCharArray();
				for(int j=0; j<c.length; j++){
					bw.write(c[j]);
					if(j < c.length-1) bw.write(" ");
				}
				bw.write("\n");
			}
		}

		bw.flush();
	}

	public static String sortString(String s){
		char c[] = s.toCharArray();
		Arrays.sort(c);
		return new String(c);
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
