import java.awt.geom.Point2D;
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
			String[] line = l.split(" ");

			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);
			int s = Integer.parseInt(line[2]);
			int v = Integer.parseInt(line[3]);

			Point2D.Double[] gophers = new Point2D.Double[n];
			Point2D.Double[] holes = new Point2D.Double[m];

			for(int i=0; i<n; i++) {
				line = br.readLine().split(" ");
				double x = Double.parseDouble(line[0]);
				double y = Double.parseDouble(line[1]);
				gophers[i] = new Point2D.Double(x, y);
			}

			for(int i=0; i<m; i++) {
				line = br.readLine().split(" ");
				double x = Double.parseDouble(line[0]);
				double y = Double.parseDouble(line[1]);
				holes[i] = new Point2D.Double(x, y);
			}

			int totalN = n+m+2;

			g = new ArrayList[totalN];
			for(int i = 0; i < totalN; i++){
				g[i] = new ArrayList<Integer>();
			}
			parent = new int[totalN];
			cap = new int[totalN][totalN];
			flow = new int[totalN][totalN];

			int source = n+m;
			int target = n+m+1;

			for(int i=0; i<n; i++) {
				g[source].add(i);
				g[i].add(source);
				cap[source][i] = 1;
			}

			for(int i=0; i<m; i++) {
				int hole = i + n;
				g[hole].add(target);
				g[target].add(hole);
				cap[hole][target] = 1;
			}

			double maxPossibleDistance = v*s*1.0;

			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					double distance = gophers[i].distance(holes[j]);
					int hole = j + n;
					if(distance <= maxPossibleDistance) { //Not best practice but sufficient for this problem
						g[i].add(hole);
						g[hole].add(i);
						cap[i][hole] = 1;
					}
				}
			}

			int matched = maxFlow(source, target);
			System.out.println(n - matched);
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
