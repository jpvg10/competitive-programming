import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String s;
		while((s = br.readLine()) != null){
			String l[] = s.split(" ");
			int m = Integer.parseInt(l[0]);
			int n = Integer.parseInt(l[1]);

			if(m == 0 && n == 0) break;

			ArrayList<Arista> aristas = new ArrayList<Arista>();
			int totalCost = 0;

			for(int j=0; j<n; j++){
				l = br.readLine().split(" ");
				int x = Integer.parseInt(l[0]);
				int y = Integer.parseInt(l[1]);
				int z = Integer.parseInt(l[2]);
				totalCost += z;
				aristas.add(new Arista(x, y, z));
			}

			int save = totalCost - kruskal(aristas, m);
			System.out.println(save);
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
