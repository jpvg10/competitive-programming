import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
	
	static ArrayList<Integer> g[];
	static boolean seen[];
	static int color[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true){
			int n = Integer.parseInt(br.readLine());
			
			if(n == 0) break;
			
			g = new ArrayList[n];
			seen = new boolean[n];
			color = new int[n];
			
			for(int i=0; i<n; i++){
				color[i] = -1;
				g[i] = new ArrayList<Integer>();
			}
			
			int l = Integer.parseInt(br.readLine());
			
			for(int i=0; i<l; i++){
				String s[] = br.readLine().split(" ");
				int u = Integer.parseInt(s[0]);
				int v = Integer.parseInt(s[1]);
				g[u].add(v);
				g[v].add(u);
			}
			
			if(isBipartite()){
				System.out.println("BICOLORABLE.");
			}else{
				System.out.println("NOT BICOLORABLE.");
			}			
		}
	}
	
	private static boolean isBipartite(){		
		LinkedList<Integer> queue = new LinkedList<Integer>();

		int source = 0;
		seen[source] = true;
		color[source] = 0;
		queue.add(source);

		while(!queue.isEmpty()){
			source = queue.poll();
			int adyLen = g[source].size();
			for(int i=0; i<adyLen; i++){
				int v = g[source].get(i);
				if(!seen[v]){
					seen[v] = true;
					color[v] = 1 - color[source];
					queue.add(v);
				}else if(color[v] != 1-color[source]){
					return false;
				}
			}
		}
		
		return true;
	}

}
