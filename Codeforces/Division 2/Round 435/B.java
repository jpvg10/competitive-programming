import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class B {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static int color[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();

		seen = new boolean[n];
		color = new int[n];
		g = new ArrayList[n];
		for(int i=0; i<n; i++){
			g[i] = new ArrayList<Integer>();
		}

		for(int i=0; i<n-1; i++) {
			int u = sc.nextInt() - 1;
			int v = sc.nextInt() - 1;
			g[u].add(v);
			g[v].add(u);
		}

		bfs(0);

		ArrayList<Integer> left = new ArrayList<Integer>();
		for(int i=0; i<n; i++) {
			if(color[i] == 0) left.add(i);
		}

		int rightSize = n - left.size();
		long ans = 0;

		for(int i : left) {
			ans += (rightSize - g[i].size());
		}

		System.out.println(ans);
		sc.close();
	}

	private static void bfs(int u){
		color[u] = 0;
		seen[u] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);

		while(!q.isEmpty()){
			u = q.poll();
			int len = g[u].size();
			for(int i=0; i<len; i++){
				int v = g[u].get(i);
				if(!seen[v]){
					color[v] = 1-color[u];
					seen[v] = true;
					q.add(v);
				}
			}
		}
	}

}
