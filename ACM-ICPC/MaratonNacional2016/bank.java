import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;

//Accepted in UVa
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=5038
class Nodo implements Comparable<Nodo>{
	int id;
	int distancia;
	public Nodo(int id, int distancia){
		this.id = id;
		this.distancia = distancia;
	}
	public int compareTo(Nodo o) {
		return this.distancia-o.distancia;
	}
}

public class bank {

	static ArrayList<Integer> g[];
	static int[][] pesos;
	static int[] distancias;
	static boolean[] visitado;
	static PriorityQueue<Nodo> proximo;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s;
		while((s = br.readLine()) != null){
			String l[] = s.split(" ");
			int n = Integer.parseInt(l[0]);
			int m = Integer.parseInt(l[1]);
			int b = Integer.parseInt(l[2]);
			int p = Integer.parseInt(l[3]);

			g = new ArrayList[n];
			pesos = new int[n][n];
			distancias = new int[n];
			proximo = new PriorityQueue<Nodo>();

			for(int i=0; i<n; i++){
				g[i] = new ArrayList<Integer>();
				distancias[i] = Integer.MAX_VALUE;
			}

			for(int i=0; i<m; i++){
				l = br.readLine().split(" ");
				int u = Integer.parseInt(l[0]);
				int v = Integer.parseInt(l[1]);
				int t = Integer.parseInt(l[2]);
				g[u].add(v);
				g[v].add(u);
				pesos[u][v] = t;
				pesos[v][u] = t;
			}

			boolean[] bank = new boolean[n];
			l=br.readLine().split(" ");

			for(int i=0; i<b; i++){
				int x = Integer.parseInt(l[i]);
				bank[x] = true;
			}

			if(p > 0){
				l=br.readLine().split(" ");
				for(int i=0; i<p; i++){
					int src = Integer.parseInt(l[i]);
					dijkstra(src);
				}
			}

			ArrayList<Integer> bankSolution = new ArrayList<Integer>();
			int maxTime = -1;

			for(int i=0; i<n; i++){
				if(bank[i] && distancias[i] > maxTime){
					bankSolution = new ArrayList<Integer>();
					bankSolution.add(i);
					maxTime = distancias[i];
				}else if(bank[i] && distancias[i] == maxTime){
					bankSolution.add(i);
				}
			}

			bw.write(bankSolution.size() + " ");
			if(maxTime == Integer.MAX_VALUE){
				bw.write("*");
			}else{
				bw.write(maxTime + "");
			}
			bw.newLine();
			for(int i=0; i<bankSolution.size(); i++){
				if(i > 0) bw.write(" ");
				bw.write(bankSolution.get(i) + "");
			}
			bw.newLine();
		}

		bw.flush();
	}

	public static void dijkstra(int src){
		visitado = new boolean[distancias.length];
		distancias[src] = 0;
		proximo.add(new Nodo(src, 0));

		while(!proximo.isEmpty()) {
			Nodo u = proximo.poll();
			if(!visitado[u.id]){
				visitado[u.id] = true;
				int len = g[u.id].size();
				for (int i=0; i<len; i++) {
					int v = g[u.id].get(i);
					if(u.distancia + pesos[u.id][v] < distancias[v]){
						distancias[v] = u.distancia + pesos[u.id][v];
						proximo.add(new Nodo(v, distancias[v]));
					}
				}
			}
		}
	}

}
