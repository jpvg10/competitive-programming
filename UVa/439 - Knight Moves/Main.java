import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {

	private static ArrayList<Integer> g[];

	public static void main(String[] args) throws IOException {
		g = new ArrayList[64];

		for(int i=0; i<8; i++){
			for(int j=0; j<8; j++){
				int k = i*8 + j;
				g[k] = new ArrayList<Integer>();
				if(i-2 >= 0 && j+1 <= 7){
					g[k].add((i-2)*8 + (j+1));
				}
				if(i-2 >= 0 && j-1 >= 0){
					g[k].add((i-2)*8 + (j-1));
				}
				if(i+2 <= 7 && j+1 <= 7){
					g[k].add((i+2)*8 + (j+1));
				}
				if(i+2 <= 7 && j-1 >= 0){
					g[k].add((i+2)*8 + (j-1));
				}
				if(i-1 >= 0 && j+2 <= 7){
					g[k].add((i-1)*8 + (j+2));
				}
				if(i-1 >= 0 && j-2 >= 0){
					g[k].add((i-1)*8 + (j-2));
				}
				if(i+1 <= 7 && j+2 <= 7){
					g[k].add((i+1)*8 + (j+2));
				}
				if(i+1 <= 7 && j-2 >= 0){
					g[k].add((i+1)*8 + (j-2));
				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l = br.readLine()) != null){
			String st[] = l.split(" ");
			int aColumn = st[0].charAt(0) - 'a';
			int aRow = st[0].charAt(1) - '0';
			int bColumn = st[1].charAt(0) - 'a';
			int bRow = st[1].charAt(1) - '0';
			int a = (aRow-1)*8 + aColumn;
			int b = (bRow-1)*8 + bColumn;
			int hops = shortestHop(a, b);
			System.out.println("To get from " + st[0] + " to " + st[1] + " takes " + hops + " knight moves.");
		}

	}

	public static int shortestHop(int s, int v){
		int n = g.length;
		int dist[] = new int[n];

		for(int i=0; i<n; i++){
			if(i != s){
				dist[i] = Integer.MAX_VALUE;
			}
		}

		//BFS
		boolean seen[] = new boolean[n];
		LinkedList<Integer> q = new LinkedList<Integer>();

		seen[s] = true;
		q.add(s);

		while(!q.isEmpty()){
			s = q.poll();
			int adyLen = g[s].size();
			for(int i=0; i<adyLen; i++){
				int w = g[s].get(i);
				if(!seen[w]){
					seen[w] = true;
					q.add(w);
					dist[w] = dist[s] + 1;
				}
			}
		}

		return dist[v];
	}

}
