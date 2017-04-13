import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++){
			br.readLine();
			if(i > 0) System.out.println();
			int m = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());

			ArrayList<Arista> aristas = new ArrayList<Arista>();
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			int current = 0;

			for(int j=0; j<n; j++){
				String line[] = br.readLine().split(" ");
				int u, v;
				if(map.containsKey(line[0])){
					u = map.get(line[0]);
				}else{
					u = current;
					map.put(line[0], current);
					current++;
				}
				if(map.containsKey(line[1])){
					v = map.get(line[1]);
				}else{
					v = current;
					map.put(line[1], current);
					current++;
				}
				int cost = Integer.parseInt(line[2]);
				aristas.add(new Arista(u, v, cost));
			}

			int mst = kruskal(aristas, m);
			System.out.println(mst);
		}
	}

	public static int kruskal(ArrayList<Arista> aristas, int n){
		Collections.sort(aristas);

		UnionFind uf = new UnionFind(n);
		int costoMST = 0;
		int i = 0;
		while(uf.getComponents() != 1){
			Arista a = aristas.get(i);
			if(!uf.connected(a.u, a.v)){
				uf.union(a.u, a.v);
				costoMST += a.costo;
			}
			i++;
		}

		return costoMST;
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
