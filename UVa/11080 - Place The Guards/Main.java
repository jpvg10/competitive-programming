import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static ArrayList<Integer> g[];
	static boolean[] seen;
	static int[] color;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++) {
			String[] line = br.readLine().split(" ");

			int v = Integer.parseInt(line[0]);
			int e = Integer.parseInt(line[1]);

			seen = new boolean[v];
			g = new ArrayList[v];
			for(int j=0; j<v; j++){
				g[j] = new ArrayList<Integer>();
			}
			color = new int[v];

			for(int j=0; j<e; j++) {
				line = br.readLine().split(" ");
				int a = Integer.parseInt(line[0]);
				int b = Integer.parseInt(line[1]);
				g[a].add(b);
				g[b].add(a);
			}

			boolean possible = true;

			int totalGuards = 0;

			for(int j=0; j<v; j++) {
				if(!seen[j]) {
					Arrays.fill(color, -1);
					possible = possible && bfs(j);
					if(!possible) break;

					int red = 0;
					int blue = 0;
					for(int k=0; k<v; k++) {
						if(color[k] == 0) {
							red++;
						}else if(color[k] == 1){
							blue++;
						}
					}
					if(red == 0 || blue == 0) {
						totalGuards += 1;
					}else {
						totalGuards += Integer.min(red, blue);
					}
				}
			}

			if(possible) {
				System.out.println(totalGuards);
			}else {
				System.out.println(-1);
			}
		}
	}

	private static boolean bfs(int u){
		seen[u] = true;
		color[u] = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while(!q.isEmpty()){
			u = q.poll();
			int len = g[u].size();
			for(int i=0; i<len; i++){
				int v = g[u].get(i);
				if(!seen[v]){
					seen[v] = true;
					color[v] = 1 - color[u];
					q.add(v);
				}else if(color[v] == color[u]) {
					return false;
				}
			}
		}

		return true;
	}

}
