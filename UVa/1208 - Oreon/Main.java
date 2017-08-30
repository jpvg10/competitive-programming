import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.StringTokenizer;

//Was getting runtime errors, StringTokenizer and Scanner solved them
public class Main {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		int t = Integer.parseInt(sc.nextLine());

		for(int i=1; i<=t; i++) {
			int n = Integer.parseInt(sc.nextLine());
			ArrayList<Arista> aristas = new ArrayList<Arista>();

			for(int j=0; j<n; j++) {
				StringTokenizer st = new StringTokenizer(sc.nextLine(), ",| ");
				for(int k=0; k<n; k++) {
					int c = Integer.parseInt(st.nextToken());
					if(c != 0) {
						aristas.add(new Arista(j, k, c));
					}
				}
			}

			System.out.println("Case " + i + ":");
			kruskal(aristas, n);
		}

		sc.close();
	}

	public static void kruskal(ArrayList<Arista> aristas, int n){
		Collections.sort(aristas);

		UnionFind uf = new UnionFind(n);
		int i = 0;
		while(uf.getComponents() != 1){
			Arista a = aristas.get(i);
			if(!uf.connected(a.u, a.v)){
				uf.union(a.u, a.v);
				char ciudadU = (char)(a.u + 'A');
				char ciudadV = (char)(a.v + 'A');
				System.out.println(ciudadU + "-" + ciudadV + " " + a.costo);
			}
			i++;
		}
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
	private int[] parent, size;
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
