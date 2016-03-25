import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UnionFind uf;
		
		int t = Integer.parseInt(sc.nextLine());
		sc.nextLine();
		
		for(int i=0; i<t; i++){
			int n = Integer.parseInt(sc.nextLine());
			uf = new UnionFind(n);
			int right = 0, wrong = 0;
			if(i>0) System.out.println();
			while(sc.hasNextLine()){
				String l = sc.nextLine();
				if(l.equals("")){
					break;
				}else if(l.charAt(0)=='c'){
					String s[] = l.split(" ");
					uf.union(Integer.parseInt(s[1])-1, Integer.parseInt(s[2])-1);
				}else{
					String s[] = l.split(" ");
					if(uf.connected(Integer.parseInt(s[1])-1, Integer.parseInt(s[2])-1))
						right++;
					else
						wrong++;
				}				
			}
			System.out.format("%d,%d\n",right,wrong);
		}
		sc.close();
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

