import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

//Avaliable at: https://uva.onlinejudge.org/index.php?option=onlinejudge&page=show_problem&problem=4648
public class wlinks {
	
	static ArrayList<Integer> g[];
	static boolean seen[];
	static int disc[];
	static int low[];
	static int time;
	static int parent[];
	static ArrayList<Bridge> bridgeEdges;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String l[] = bf.readLine().split(" "); 
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);

		while(n != 0 && m != 0){
			seen = new boolean[n];
			disc = new int[n];
			low = new int[n];
			time = 0;
			parent = new int[n];
			bridgeEdges = new ArrayList<Bridge>();
			g = new ArrayList[n];

			for(int i = 0; i < n; i++){
				g[i] = new ArrayList<Integer>();
			}

			for(int i=0; i<m; i++){
				String []conectados = bf.readLine().split(" ");
				int ni = Integer.parseInt(conectados[0]);
				int nj = Integer.parseInt(conectados[1]);

				g[ni].add(nj);
				g[nj].add(ni);
			}

			for(int i=0; i<n; i++){
				parent[i] = -1;
			}

			for(int u=0; u<n; u++){
				if(!seen[u]){
					bridges(u);
				}
			}
			
			Collections.sort(bridgeEdges);
			
			int links = bridgeEdges.size();
			
			bw.write(links + "");
			for(int i=0; i<links; i++){
				bw.write(" " + bridgeEdges.get(i).u + " " + bridgeEdges.get(i).v);
			}
			bw.write("\n");
			
			l = bf.readLine().split(" ");
			n = Integer.parseInt(l[0]);
			m = Integer.parseInt(l[1]);
		}
		bw.flush();
	}

	private static void bridges(int u){
		seen[u] = true;
		disc[u] = time;
		low[u] = time;
		time++;

		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				parent[v] = u;
				bridges(v);
				low[u] = Math.min(low[u], low[v]);
				if(low[v] > disc[u]){
					Bridge b = new Bridge(u, v);
					bridgeEdges.add(b);
				}
			}else if(v != parent[u]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
}

class Bridge implements Comparable<Bridge> {
	public int u;
	public int v;
	
	public Bridge(int u, int v){
		if(u < v){
			this.u = u;
			this.v = v;
		}else{
			this.u = v;
			this.v = u;
		}		
	}
	
	public int compareTo(Bridge o) {
		if(o.u != this.u){
			return this.u - o.u;
		}else{
			return this.v - o.v;
		}
	}	
}
