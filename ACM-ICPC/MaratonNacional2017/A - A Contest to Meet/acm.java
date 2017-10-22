import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Accepted in Competition
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=5172
public class acm {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String l;
		while((l = br.readLine()) != null){
			String[] line = l.split(" ");
			int n = Integer.parseInt(line[0]);
			int s = Integer.parseInt(line[1]);

			int[][] grafo = new int[n][n];
			int[][] A = new int[n][n];

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(i != j){
						grafo[i][j] = Integer.MAX_VALUE;
					}
				}
			}

			for(int i=0; i<s; i++){
				line = br.readLine().split(" ");
				int u = Integer.parseInt(line[0]);
				int v = Integer.parseInt(line[1]);
				int d = Integer.parseInt(line[2]);
				grafo[u][v] = d;
				grafo[v][u] = d;
			}

			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					A[i][j] = grafo[i][j];
				}
			}

			for(int k=0; k<n; k++){
				for(int i=0; i<n; i++){
					for(int j=0; j<n; j++){
						int option1 = A[i][j];
						int option2;
						if(A[i][k] == Integer.MAX_VALUE || A[k][j] == Integer.MAX_VALUE){
							option2 = Integer.MAX_VALUE;
						}else{
							option2 = A[i][k] + A[k][j];
						}
						A[i][j] = Integer.min(option1, option2);
					}
				}
			}

			line = br.readLine().split(" ");
			int slowest = Integer.MAX_VALUE;
			for(int i=0; i<3; i++){
				int sp = Integer.parseInt(line[i]);
				if(sp < slowest){
					slowest = sp;
				}
			}

			int longest = -1;
			for(int i=0; i<n; i++){
				for(int j=0; j<n; j++){
					if(A[i][j] > longest){
						longest = A[i][j];
					}
				}
			}

			int ans = (int) Math.ceil((double) longest / (double)slowest);
			bw.write(ans + "\n");
		}

		bw.flush();
	}
}
