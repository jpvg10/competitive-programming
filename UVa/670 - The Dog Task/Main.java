import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Getting runtime error with BufferedReader
public class Main {

	static ArrayList<Integer> g[];
	static int[] parent;
	static int[][] cap;
	static int[][] flow;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int l = sc.nextInt();

		for(int i=0; i<l; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			Point2D.Double[] route = new Point2D.Double[n];
			Point2D.Double[] interesting = new Point2D.Double[m];

			for(int j=0; j<n; j++) {
				double x = sc.nextInt();
				double y = sc.nextInt();
				route[j] = new Point2D.Double(x, y);
			}

			for(int j=0; j<m; j++) {
				double x = sc.nextInt();
				double y = sc.nextInt();
				interesting[j] = new Point2D.Double(x, y);
			}

			int totalN = n+m+2;

			g = new ArrayList[totalN];
			for(int j = 0; j<totalN; j++){
				g[j] = new ArrayList<Integer>();
			}
			parent = new int[totalN];
			cap = new int[totalN][totalN];
			flow = new int[totalN][totalN];

			int source = n+m;
			int target = n+m+1;

			for(int j=0; j<n; j++) {
				g[source].add(j);
				g[j].add(source);
				cap[source][j] = 1;
			}

			for(int j=0; j<m; j++) {
				int place = j + n;
				g[place].add(target);
				g[target].add(place);
				cap[place][target] = 1;
			}

			for(int j=0; j<n-1; j++) {
				for(int k=0; k<m; k++) {
					double dogDistance = route[j].distance(interesting[k]) + interesting[k].distance(route[j+1]);
					double hunterDistance = route[j].distance(route[j+1]);
					if(dogDistance <= 2 * hunterDistance) { //Not best practice but sufficient for this problem
						int place = k + n;
						g[j].add(place);
						g[place].add(j);
						cap[j][place] = 1;
					}
				}
			}

			int visited = maxFlow(source, target);
			System.out.format("%d\n", visited + n);

			for(int j=0; j<n; j++) {
				System.out.format("%.0f %.0f", route[j].getX(), route[j].getY());
				if(j<n-1) System.out.format(" ");
				for(int k=0; k<m; k++) {
					if(flow[j][k+n] == 1) {
						System.out.format("%.0f %.0f ", interesting[k].getX(), interesting[k].getY());
						break;
					}
				}
			}

			System.out.format("\n");
			if(i < l-1) System.out.format("\n");
		}

		sc.close();
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
