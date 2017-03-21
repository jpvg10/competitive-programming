import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static ArrayList<Integer> g[];
	static boolean seen[];
	static int parent[];
	static int M[][];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		HashMap<String, Integer> names = new HashMap<String, Integer>();
		int count = 0;

		M = new int[60][60];
		g = new ArrayList[60];
		for(int i=0; i<60; i++){
			g[i] = new ArrayList<Integer>();
		}

		String line = br.readLine();
		while(!line.equals(".")){
			String s[] = line.split(" ");
			if(s[0].equals("!")){
				int n = Integer.parseInt(s[1]);
				int m = Integer.parseInt(s[4]);
				int x, y;

				if(names.containsKey(s[2])){
					x = names.get(s[2]);
				}else{
					x = count;
					names.put(s[2], count);
					count++;
				}

				if(names.containsKey(s[5])){
					y = names.get(s[5]);
				}else{
					y = count;
					names.put(s[5], count);
					count++;
				}

				g[x].add(y);
				g[y].add(x);
				M[x][y] = n;
				M[y][x] = m;
			}else{
				int x = names.get(s[1]);
				int y = names.get(s[3]);

				bfs(x);

				if(seen[y]){
					int current = y;
					int prev = parent[y];
					int num = 1;
					int den = 1;

					do{
						num = num * M[prev][current];
						den = den * M[current][prev];
						current = prev;
						prev = parent[current];
					}while(current != prev);

					int div = gcd(num, den);
					System.out.println((num/div) + " " + s[1] + " = " + (den/div) + " "+ s[3]);
				}else{
					System.out.println("? " + s[1] + " = ? " + s[3]);
				}
			}

			line = br.readLine();
		}

	}

	private static void bfs(int u){
		seen = new boolean[60];
		parent = new int[60];
		Arrays.fill(parent, -1);
		parent[u] = u;
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
					parent[v] = u;
				}
			}
		}
	}

	public static int gcd(int a, int b){
		while(b != 0){
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}
}
