import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {

	static ArrayList<Integer> grafo[];
	static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s;
		while((s = br.readLine()) != null){
			int t = Integer.parseInt(s);
			
			for(int i=0; i<t; i++){
				String line[] = br.readLine().split(" ");
				int n = Integer.parseInt(line[0]);
				int m = Integer.parseInt(line[1]);
				int l = Integer.parseInt(line[2]);
				
				visited = new boolean[n];
				grafo = new ArrayList[n];
				for(int j=0; j<n; j++)
					grafo[j] = new ArrayList<Integer>();
				
				for(int j=0; j<m; j++){
					line = br.readLine().split(" ");
					int src = Integer.parseInt(line[0]) - 1;
					int dest = Integer.parseInt(line[1]) - 1;
					grafo[src].add(dest);
				}
				
				for(int j=0;  j<l; j++){
					int u = Integer.parseInt(br.readLine()) - 1;
					dfs(u);
				}
				
				int knocked = 0;
				for(int j=0; j<n; j++){
					if(visited[j])
						knocked++;
				}
				
				System.out.println(knocked);
			}
		}
	}
	
	public static void dfs(int u){
		visited[u] = true;
		int l = grafo[u].size();
		for(int i=0; i<l; i++){
			if(!visited[grafo[u].get(i)]){
				dfs(grafo[u].get(i));
			}
		}
	}

}
