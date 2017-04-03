import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static int dist[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int testCase = 0;

		while(sc.hasNextInt()){
			int a = sc.nextInt();
			int b = sc.nextInt();
			if(a == 0 && b == 0) break;

			testCase++;

			HashMap<Integer, Integer> nodes = new HashMap<Integer, Integer>();
			ArrayList<Edge> edges = new ArrayList<Edge>();
			int count = 0;

			while(a != 0 && b != 0){
				int labelA, labelB;
				if(nodes.containsKey(a)){
					labelA = nodes.get(a);
				}else{
					labelA = count;
					nodes.put(a, count);
					count++;
				}
				if(nodes.containsKey(b)){
					labelB = nodes.get(b);
				}else{
					labelB = count;
					nodes.put(b, count);
					count++;
				}
				edges.add(new Edge(labelA, labelB));

				a = sc.nextInt();
				b = sc.nextInt();
			}

			int n = nodes.size();

			dist = new int[n];
			g = new ArrayList[n];
			for(int i=0; i<n; i++){
				g[i] = new ArrayList<Integer>();
			}

			for(Edge e : edges){
				g[e.a].add(e.b);
			}

			int totalSum = 0;

			for(int i=0; i<n; i++){
				shortestHop(i);
				int sum = 0;
				for(int j=0; j<n; j++){
					sum += dist[j];
				}
				totalSum += sum;
			}

			double average = (double)totalSum / (double)(n*(n-1));

			System.out.format("Case %d: average length between pages = %.3f clicks\n", testCase, average);
		}

	}

	public static void shortestHop(int u){
		int n = g.length;

		seen = new boolean[n];
		for(int i=0; i<n; i++){
			dist[i] = Integer.MAX_VALUE;
		}
		dist[u] = 0;

		seen[u] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(u);
		while(!q.isEmpty()){
			u = q.poll();
			int len = g[u].size();
			for(int i=0; i<len; i++){
				int v = g[u].get(i);
				if(!seen[v]){
					seen[v] = true;
					q.add(v);
					dist[v] = dist[u] + 1;
				}
			}
		}
	}

}

class Edge {
	public int a, b;
	public Edge(int a, int b){
		this.a = a;
		this.b = b;
	}
}
