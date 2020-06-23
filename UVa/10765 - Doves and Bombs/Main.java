import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
	static ArrayList<Integer> g[];
	static boolean[] seen, isAp;
	static int[] disc, low, parent;
	static int time;
	static HashSet<Integer> ap;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] line;

		while(true) {
			line = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);

			if(n == 0 && m == 0) break;

			g = new ArrayList[n];
			seen = new boolean[n];
			isAp = new boolean[n];
			disc = new int[n];
			low = new int[n];
			parent = new int[n];
			time = 0;
			ap = new HashSet<Integer>();

			for(int i = 0; i < n; i++){
				g[i] = new ArrayList<Integer>();
				parent[i] = -1;
			}

			while(true) {
				line = br.readLine().split(" ");
				int u = Integer.parseInt(line[0]);
				int v = Integer.parseInt(line[1]);

				if(u == -1 && v == -1) break;

				g[u].add(v);
				g[v].add(u);
			}

			articulationPoints(0);

			int apSize = ap.size();
			Target[] targets = new Target[apSize];

			int k = 0;
			for(int u : ap) {
				int components = 0;
				seen = new boolean[n];
				for(int j=0; j<n; j++) {
					if(!seen[j] && j != u) {
						components++;
						dfsSkip(j, u);
					}
				}
				targets[k] = new Target(u, components);
				k++;
			}

			Arrays.sort(targets);

			for(int i=0; i<m && i<apSize; i++) {
				bw.write(targets[i].label + " " + targets[i].pigeonValue + "\n");
			}

			if(m > apSize) {
				int dif = m - apSize;
				for(int i=0; i<n && dif > 0; i++) {
					if(!isAp[i]) {
						bw.write(i + " 1\n");
						dif--;
					}
				}
			}

			bw.newLine();
			bw.flush();
		}
	}

	private static void articulationPoints(int u){
		seen[u] = true;
		disc[u] = time;
		low[u] = time;
		time++;
		int children = 0;

		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				children++;
				parent[v] = u;
				articulationPoints(v);
				low[u] = Math.min(low[u], low[v]);
				if(parent[u] == -1 && children > 1){
					ap.add(u);
					isAp[u] = true;
				}else if(parent[u] != -1 && low[v] >= disc[u]){
					ap.add(u);
					isAp[u] = true;
				}
			}else if(v != parent[u]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}

	private static void dfsSkip(int u, int skip) {
		seen[u] = true;
		for(int v : g[u]) {
			if(!seen[v] && v != skip) {
				dfsSkip(v, skip);
			}
		}
	}
}

class Target implements Comparable<Target> {
	public int label, pigeonValue;

	public Target(int label, int pigeonValue) {
		this.label = label;
		this.pigeonValue = pigeonValue;
	}

	@Override
	public int compareTo(Target o) {
		if(this.pigeonValue == o.pigeonValue) {
			return this.label - o.label;
		}
		return o.pigeonValue - this.pigeonValue;
	}
}