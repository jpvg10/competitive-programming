import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static ArrayList<Integer> g[];
	static int[] parent;
	static int[][] cap;
	static int[][] flow;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int network = 1;

		String l;
		while((l = br.readLine()) != null) {
			int n = Integer.parseInt(l);
			if(n == 0) break;

			String[] line = br.readLine().split(" ");
			int s = Integer.parseInt(line[0]) - 1;
			int t = Integer.parseInt(line[1]) - 1;
			int c = Integer.parseInt(line[2]);

			g = new ArrayList[n];
			for(int i = 0; i < n; i++){
				g[i] = new ArrayList<Integer>();
			}

			parent = new int[n];
			cap = new int[n][n];
			flow = new int[n][n];

			for(int i=0; i<c; i++){
				line = br.readLine().split(" ");
				int u = Integer.parseInt(line[0]) - 1;
				int v = Integer.parseInt(line[1]) - 1;
				int bandwidth = Integer.parseInt(line[2]);
				g[u].add(v);
				g[v].add(u);
				cap[u][v] += bandwidth;
				cap[v][u] += bandwidth;
			}

			int max = maxFlow(s, t);
			bw.write("Network " + network + "\n");
			bw.write("The bandwidth is " + max + ".\n\n");
			network++;
		}

		bw.flush();
	}

	public static int maxFlow(int s, int t) {
		int ans = 0;

		while(true) {
			Arrays.fill(parent, -1);
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(s);

			while(!q.isEmpty()) {
				int u = q.poll();
				if(u == t) break;

				int len = g[u].size();
				for(int i=0; i<len; i++){
					int v = g[u].get(i);
					if(parent[v] == -1 && cap[u][v] - flow[u][v] > 0){
						q.add(v);
						parent[v] = u;
					}
				}
			}
			if(parent[t] == -1) break;

			int bottleneck = Integer.MAX_VALUE;
			int end = t;
			while(end != s) {
				int start = parent[end];
				bottleneck = Integer.min(bottleneck, cap[start][end] - flow[start][end]);
				end = start;
			}

			end = t;
			while(end != s) {
				int start = parent[end];
				flow[start][end] += bottleneck;
				flow[end][start] = -flow[start][end];
				end = start;
			}

			ans += bottleneck;
		}

		return ans;
	}

}
