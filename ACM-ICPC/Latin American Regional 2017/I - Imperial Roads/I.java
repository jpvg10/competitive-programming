import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

//Accepted in URI
//Available at: https://www.urionlinejudge.com.br/judge/en/problems/view/2703
public class I {

	static ArrayList<Integer> tree[];
	static HashMap<String, Integer> edgeWeight;
	static boolean[] seen;
	static int[] depth;
	static int maxDepth;
	static int[] parent;
	static int[][] table;
	static int[][] maxParentEdge;
	static int edge;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] l = br.readLine().split(" ");

		int n = Integer.parseInt(l[0]);
		int r = Integer.parseInt(l[1]);

		ArrayList<Edge> edges = new ArrayList<Edge>();
		edgeWeight = new HashMap<String, Integer>();

		for (int i = 0; i < r; i++) {
			l = br.readLine().split(" ");
			int a = Integer.parseInt(l[0]) - 1;
			int b = Integer.parseInt(l[1]) - 1;
			int c = Integer.parseInt(l[2]);
			edges.add(new Edge(a, b, c));
			edgeWeight.put(a + "," + b, c);
			edgeWeight.put(b + "," + a, c);
		}

		tree = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			tree[i] = new ArrayList<Integer>();
		}

		ArrayList<Edge> mst = kruskal(edges, n);

		int m = mst.size();
		int mstWeight = 0;

		for (int i = 0; i < m; i++) {
			int u = mst.get(i).u;
			int v = mst.get(i).v;
			int c = mst.get(i).cost;
			tree[u].add(v);
			tree[v].add(u);
			mstWeight += c;
		}

		seen = new boolean[n];
		depth = new int[n];
		depth[0] = 0;
		parent = new int[n];
		parent[0] = 0;

		bfs(0);

		buildTable(n);

		int q = Integer.parseInt(br.readLine());
		for (int i = 0; i < q; i++) {
			l = br.readLine().split(" ");
			int u = Integer.parseInt(l[0]) - 1;
			int v = Integer.parseInt(l[1]) - 1;

			int ans = mstWeight + edgeWeight.get(u + "," + v) - maxEdgeInPath(u, v);
			bw.write(ans + "\n");
		}

		bw.close();
	}

	public static ArrayList<Edge> kruskal(ArrayList<Edge> edges, int n) {
		Collections.sort(edges);

		UnionFind uf = new UnionFind(n);
		ArrayList<Edge> mst = new ArrayList<Edge>();
		int i = 0;
		while (uf.getComponents() != 1) {
			Edge a = edges.get(i);
			if (!uf.connected(a.u, a.v)) {
				uf.union(a.u, a.v);
				mst.add(a);
			}
			i++;
		}

		return mst;
	}

	private static void bfs(int u) {
		seen[u] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while (!q.isEmpty()) {
			u = q.poll();
			int len = tree[u].size();
			for (int i = 0; i < len; i++) {
				int v = tree[u].get(i);
				if (!seen[v]) {
					seen[v] = true;
					parent[v] = u;
					depth[v] = depth[u] + 1;
					q.add(v);
				}
			}
		}
	}

	public static int log2(int n) {
		return 31 - Integer.numberOfLeadingZeros(n);
	}

	public static void buildTable(int n) {
		maxDepth = log2(n);

		table = new int[maxDepth + 1][n];
		maxParentEdge = new int[maxDepth + 1][n];

		for (int i = 0; i <= maxDepth; i++) {
			Arrays.fill(table[i], -1);
		}

		for (int i = 0; i < n; i++) {
			table[0][i] = parent[i];
			if (i != parent[i]) {
				maxParentEdge[0][i] = edgeWeight.get(i + "," + parent[i]);
			}
		}

		for (int d = 1; d <= maxDepth; d++) {
			for (int i = 0; i < n; i++) {
				int mid = table[d - 1][i];
				if (mid != -1) {
					table[d][i] = table[d - 1][mid];
					maxParentEdge[d][i] = Integer.max(maxParentEdge[d - 1][i], maxParentEdge[d - 1][mid]);
				}
			}
		}
	}

	public static int walk(int i, int k) {
		for (int d = 0; d <= maxDepth && i != -1; d++) {
			if (((1 << d) & k) > 0) {
				edge = Integer.max(edge, maxParentEdge[d][i]);
				i = table[d][i];
			}
		}
		return i;
	}

	public static int maxEdgeInPath(int u, int v) {
		edge = -1;

		if (depth[u] > depth[v]) {
			u = walk(u, depth[u] - depth[v]);
		} else if (depth[v] > depth[u]) {
			v = walk(v, depth[v] - depth[u]);
		}

		if (u == v) {
			return edge;
		}

		for (int d = maxDepth; d >= 0; d--) {
			if (table[d][u] != table[d][v]) {
				edge = Integer.max(edge, maxParentEdge[d][u]);
				edge = Integer.max(edge, maxParentEdge[d][v]);
				u = table[d][u];
				v = table[d][v];
			}
		}

		edge = Integer.max(edge, maxParentEdge[0][u]);
		edge = Integer.max(edge, maxParentEdge[0][v]);
		return edge;
	}
}

class Edge implements Comparable<Edge> {
	public int u, v, cost;

	public Edge(int u, int v, int cost) {
		this.u = u;
		this.v = v;
		this.cost = cost;
	}

	public int compareTo(Edge o) {
		return this.cost - o.cost;
	}
}

class UnionFind {
	private int[] parent, size;
	private int components;

	public UnionFind(int n) {
		components = n;
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
	}

	private int root(int p) {
		while (p != parent[p]) {
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q) {
		int rootP = root(p);
		int rootQ = root(q);
		if (rootP != rootQ) {
			if (size[rootP] < size[rootQ]) {
				parent[rootP] = rootQ;
				size[rootQ] = size[rootQ] + size[rootP];
			} else {
				parent[rootQ] = rootP;
				size[rootP] = size[rootP] + size[rootQ];
			}
			components--;
		}
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public int getComponents() {
		return components;
	}
}
