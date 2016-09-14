import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Main {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static int disc[];
	static int low[];
	static int time;
	static int parent[];
	static boolean ap[];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		int caso = 1;
		
		while(n != 0){
			if(caso > 1) System.out.println();
			
			seen = new boolean[n];
			disc = new int[n];
			low = new int[n];
			time = 0;
			parent = new int[n];
			ap = new boolean[n];
			HashMap<String,Integer> mapa = new HashMap<String, Integer>();
			HashMap<Integer,String> mapaReverso = new HashMap<Integer, String>();

			for(int i=0; i<n; i++){
				parent[i]=-1;			
			}
						
			g = new ArrayList[n];
			for(int i = 0; i < n; i++){
				g[i] = new ArrayList<Integer>();
			}
			
			int count = 0;
			for(int i=0 ; i<n; i++){
				String ciudad = bf.readLine();
				mapa.put(ciudad, count);
				mapaReverso.put(count, ciudad);
				count++;
			}
			
			int calles = Integer.parseInt(bf.readLine());
			
			for(int i=0; i<calles; i++){
				String[] calle = bf.readLine().split(" ");
				int a = mapa.get(calle[0]);
				int b = mapa.get(calle[1]);
				g[a].add(b);
				g[b].add(a);
			}

			for(int u=0; u<n; u++){
				if(!seen[u]){
					articulationPoints(u);
				}
			}
			
			ArrayList<String> camaras = new ArrayList<String>();
			for(int i=0; i<n;i++){
				if(ap[i] == true){
					String c = mapaReverso.get(i);
					camaras.add(c);
				}
			}
			
			Collections.sort(camaras);			
			int s = camaras.size();
			
			System.out.println("City map #" + caso + ": " + s + " camera(s) found");
			for(int i=0; i<s; i++){
				System.out.println(camaras.get(i));
			}
			
			caso++;
			n = Integer.parseInt(bf.readLine());
		}		
	}

	private static void articulationPoints(int u){
		seen[u] = true;
		disc[u] = time;
		low[u] = time;
		time++;
		int children = 0;

		int len = g[u].size();
		for(int i=0; i<len; i++){
			int v = g[u].get(i);
			if(!seen[v]){
				children++;
				parent[v] = u;
				articulationPoints(v);
				low[u] = Math.min(low[u], low[v]);
				if(parent[u] == -1 && children > 1){
					ap[u] = true;
				}else if(parent[u] != -1 && low[v] >= disc[u]){
					ap[u] = true;
				}
			}else if(v != parent[u]){
				low[u] = Math.min(low[u], disc[v]);
			}
		}
	}
}