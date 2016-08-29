import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	
	static boolean [] seen;
	static ArrayList<Integer>[] g;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input[] = br.readLine().split(" ");
		int m = Integer.parseInt(input[0]);
		int n = Integer.parseInt(input[1]);

		while(m != 0){
			int field[][] = new int [m][n];
			for(int i =0; i<m; i++){
				String line = br.readLine();
				for(int j=0; j<n; j++){
					char current = line.charAt(j);
					if(current == '*'){
						field[i][j] = 0;
					}else{
						field[i][j] = 1;
					}
				}
			}

			g = new ArrayList[n*m];
			for(int i=0; i<n*m; i++){
				g[i] = new ArrayList<Integer>();
			}
			
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					if(field[i][j] == 1){
						int a = n*i+j;					
						g[a].add(a);						
						if(j+1<n && field[i][j+1] == 1){
							g[a].add(n*i+(j+1));	
							g[n*i+(j+1)].add(a);
						}
						if(i+1<m && field[i+1][j] == 1){
							g[a].add(n*(i+1)+j);
							g[n*(i+1)+j].add(a);
						}
						if(j+1<n && i+1<m && field[i+1][j+1] == 1){
							g[a].add(n*(i+1)+(j+1));	
							g[n*(i+1)+(j+1)].add(a);
						}
						if(j-1>=0 && i+1<m && field[i+1][j-1] == 1){
							g[a].add(n*(i+1)+(j-1));
							g[n*(i+1)+(j-1)].add(a);
						}					
					}
				}
			}
			
			seen = new boolean[n*m];
			int deposits = 0;
			
			for(int i=0; i<n*m; i++){
				if(seen[i]==false && g[i].size() != 0){
					dfs(i);
					deposits++;
				}					
			}
			
			System.out.println(deposits);
			
			input = br.readLine().split(" ");
			m = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
		}		
	}
	
	public static void dfs(int u){
		seen[u] = true;
		int l = g[u].size();
		for(int i=0; i<l; i++){
			if(!seen[g[u].get(i)]){
				dfs(g[u].get(i));
			}
		}
	}
}