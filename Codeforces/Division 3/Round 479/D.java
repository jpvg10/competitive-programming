import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class D {

	static ArrayList<Integer> g[];
	static int seen[];
	static LinkedList<Integer> topoSort;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		seen = new int[n];
		topoSort = new LinkedList<Integer>();
		g = new ArrayList[n];
		for(int i = 0; i < n; i++){
			g[i] = new ArrayList<Integer>();
		}

		long[] a = new long[n];
		for(int i=0; i<n; i++){
			a[i] = sc.nextLong();
		}

		for(int i=0; i<n; i++){
			for(int j=i+1; j<n; j++){
				if(a[i]*2 == a[j] || a[j]*3 == a[i]){
					g[i].add(j);
				}
				if(a[j]*2 == a[i] || a[i]*3 == a[j]){
					g[j].add(i);
				}
			}
		}

		for(int u=0; u<n; u++){
			if(seen[u] == 0){
				topoDfs(u);
			}
		}

		int pos = 0;
		for(int i : topoSort){
			System.out.print(a[i]);
			if(pos < n-1){
				System.out.print(" ");
			}else{
				System.out.println();
			}
			pos++;
		}

		sc.close();
	}

	private static boolean topoDfs(int u){
		seen[u] = 1;
		int len = g[u].size();
		boolean noCycle = true;
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(seen[v] == 0){
				noCycle = noCycle && topoDfs(v);
			}else if(seen[v] == 1){
				noCycle = false;
			}
		}
		seen[u] = 2;
		topoSort.addFirst(u);
		return noCycle;
	}

}
