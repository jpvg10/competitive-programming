import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l = br.readLine()) != null){
			String line[] = l.split(" ");
			int n = Integer.parseInt(line[0]);
			int m = Integer.parseInt(line[1]);

			if(n == 0 && m == 0) break;

			ArrayList<Arista> aristas = new ArrayList<Arista>();
			UnionFind graph = new UnionFind(n);

			for(int j=0; j<m; j++){
				line = br.readLine().split(" ");
				int x = Integer.parseInt(line[0]);
				int y = Integer.parseInt(line[1]);
				int z = Integer.parseInt(line[2]);
				aristas.add(new Arista(x, y, z));
				graph.union(x, y);
			}

			if(graph.getComponents() == 1){
				int largestEdge = largestKruskal(aristas, n);
				System.out.println(largestEdge);
			}else{
				System.out.println("IMPOSSIBLE");
			}
		}
	}

	//Returns the length of the largest edge added to the MST
	public static int largestKruskal(ArrayList<Arista> aristas, int n){
		Collections.sort(aristas);

		UnionFind uf = new UnionFind(n);
		int largestEdge = 0;
		int i = 0;
		while(uf.getComponents() != 1){
			Arista a = aristas.get(i);
			if(!uf.connected(a.u, a.v)){
				uf.union(a.u, a.v);
				largestEdge = a.costo;
			}
			i++;
		}

		return largestEdge;
	}
}

class Arista implements Comparable<Arista>{
	public int u, v, costo;
	public Arista(int u, int v, int costo){
		this.u = u;
		this.v = v;
		this.costo = costo;
	}
	public int compareTo(Arista o) {
		return this.costo - o.costo;
	}
}

class UnionFind{
	private int parent[];
	private int size[];
	private int components;

	public UnionFind(int n){
		components = n;
		parent = new int[n];
		size = new int[n];
		for(int i=0; i<n; i++){
			parent[i] = i;
			size[i] = 1;
		}
	}

	private int root(int p){
		while(p != parent[p]){
			parent[p] = parent[parent[p]];
			p = parent[p];
		}
		return p;
	}

	public void union(int p, int q){
		int rootP = root(p);
		int rootQ = root(q);
		if(rootP != rootQ){
			if(size[rootP] < size[rootQ]){
				parent[rootP] = rootQ;
				size[rootQ] = size[rootQ] + size[rootP];
			}else{
				parent[rootQ] = rootP;
				size[rootP] = size[rootP] + size[rootQ];
			}
			components--;
		}
	}

	public boolean connected(int p, int q){
		return root(p) == root(q);
	}

	public int getComponents(){
		return components;
	}
}
