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
				if(i-1 >= 0){
					g[k].add((i-1)*8 + j);
				}
				if(i+1 <= 7){
					g[k].add((i+1)*8 + j);
				}
				if(j-1 >= 0){
					g[k].add(i*8 + (j-1));
				}
				if(j+1 <= 7){
					g[k].add(i*8 + (j+1));
				}
				if(i-1 >= 0 && j+1 <= 7){
					g[k].add((i-1)*8 + (j+1));
				}
				if(i-1 >= 0 && j-1 >= 0){
					g[k].add((i-1)*8 + (j-1));
				}
				if(i+1 <= 7 && j+1 <= 7){
					g[k].add((i+1)*8 + (j+1));
				}
				if(i+1 <= 7 && j-1 >= 0){
					g[k].add((i+1)*8 + (j-1));
				}
			}
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int test = 1;

		String l;
		while((l = br.readLine()) != null){
			String st[] = l.split(" ");
			int r1 = Integer.parseInt(st[0]) - 1;
			int c1 = Integer.parseInt(st[1]) - 1;
			int r2 = Integer.parseInt(st[2]) - 1;
			int c2 = Integer.parseInt(st[3]) - 1;
			int r3 = Integer.parseInt(st[4]) - 1;
			int c3 = Integer.parseInt(st[5]) - 1;
			int a = r1*8 + c1;
			int b = r2*8 + c2;
			int removed = r3*8 + c3;
			int hops = shortestHop(a, b, removed);
			System.out.println("Case " + test + ": " + hops);
			test++;
		}

	}

	public static int shortestHop(int s, int v, int r){
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
				if(!seen[w] && w!=r){
					seen[w] = true;
					q.add(w);
					dist[w] = dist[s] + 1;
				}
			}
		}

		return dist[v];
	}

}
