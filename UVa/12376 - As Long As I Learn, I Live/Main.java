import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static int learn[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int i=1; i<=t; i++){
			br.readLine();
			String s[] = br.readLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);

			g = new ArrayList[n];
			seen = new boolean[n];
			learn = new int[n];

			s = br.readLine().split(" ");
			for(int j=0; j<n; j++){
				learn[j] = Integer.parseInt(s[j]);
				g[j] = new ArrayList<Integer>();
			}

			for(int j=0; j<m; j++){
				s = br.readLine().split(" ");
				int u = Integer.parseInt(s[0]);
				int v = Integer.parseInt(s[1]);
				g[u].add(v);
			}

			//BFS modificado
			int u = 0;
			int sum = 0;
			seen[u] = true;
			Queue<Integer> q = new LinkedList<Integer>();
			q.add(u);

			while(!q.isEmpty()){
				u = q.poll();
				int bestLearn = -1;
				int bestNode = -1;
				int len = g[u].size();
				for(int j=0; j<len; j++){
					int v = g[u].get(j);
					if(!seen[v] && learn[v] > bestLearn){
						bestLearn = learn[v];
						bestNode = v;
					}
				}
				if(bestNode != -1){
					seen[bestNode] = true;
					q.add(bestNode);
					sum += bestLearn;
				}
			}

			System.out.println("Case " + i + ": " + sum + " " + u);
		}
	}
}
