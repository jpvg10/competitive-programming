import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

		String l;
		while((l = br.readLine()) != null) {
			int n = Integer.parseInt(l);
			int totalN = 2*n + 2;

			g = new ArrayList[totalN];
			for(int i = 0; i < totalN; i++){
				g[i] = new ArrayList<Integer>();
			}

			parent = new int[totalN];
			cap = new int[totalN][totalN];
			flow = new int[totalN][totalN];

			String[] line = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				int regulatorCap = Integer.parseInt(line[i]);
				int regulatorLeft = 2*i;
				int regulatorRight = 2*i + 1;
				g[regulatorLeft].add(regulatorRight);
				g[regulatorRight].add(regulatorLeft);
				cap[regulatorLeft][regulatorRight] = regulatorCap;
			}

			int m = Integer.parseInt(br.readLine());

			for(int i=0; i<m; i++) {
				line = br.readLine().split(" ");
				int u = Integer.parseInt(line[0]) - 1;
				int v = Integer.parseInt(line[1]) - 1;
				int c = Integer.parseInt(line[2]);
				int uRight = 2*u + 1;
				int vLeft = 2*v;
				g[uRight].add(vLeft);
				g[vLeft].add(uRight);
				cap[uRight][vLeft] = c;
			}

			line = br.readLine().split(" ");
			int b = Integer.parseInt(line[0]);
			int d = Integer.parseInt(line[1]);
			int barisal = 2*n;
			int dhaka = 2*n + 1;

			line = br.readLine().split(" ");
			for(int i=0; i<b+d; i++) {
				int point = Integer.parseInt(line[i]) - 1;
				if(i < b) {
					int pointLeft = 2*point;
					g[barisal].add(pointLeft);
					g[pointLeft].add(barisal);
					cap[barisal][pointLeft] = Integer.MAX_VALUE;
				}else {
					int pointRight = 2*point + 1;
					g[pointRight].add(dhaka);
					g[dhaka].add(pointRight);
					cap[pointRight][dhaka] = Integer.MAX_VALUE;
				}
			}

			System.out.println(maxFlow(barisal, dhaka));
		}
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
