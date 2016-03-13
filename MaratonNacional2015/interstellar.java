import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

//Accepted in UVa
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4827
public class interstellar {
	
	static ArrayList<Integer> grafo[];
	static ArrayList<Integer> grafoReverse[];
	static Flight vuelos[][];
	static Flight A[][];
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		boolean first = true;
		
		String l;		
		while((l = br.readLine()) != null){
			HashMap<String, Integer> map = new HashMap<String, Integer>();
			
			if(!first)
				System.out.println(".");
			
			first = false;	
							
			String line[] = l.split(" ");
			int p = Integer.parseInt(line[0]);
			int f = Integer.parseInt(line[1]);
			int q = Integer.parseInt(line[2]);
			
			grafo = new ArrayList[p];
			grafoReverse = new ArrayList[p];
			vuelos = new Flight[p][p];
			
			for(int i=0; i<p; i++){
				l = br.readLine();
				map.put(l, i);
				grafo[i] = new ArrayList<Integer>();
				grafoReverse[i] = new ArrayList<Integer>();
			}
			
			for(int i=0; i<f; i++){
				line = br.readLine().split(" ");
				int s0 = map.get(line[0]);
				int sd = map.get(line[1]);
				int c = Integer.parseInt(line[2]);
				int t = Integer.parseInt(line[3]);
				if(!grafo[s0].contains(sd)){
					grafo[s0].add(sd);
					grafoReverse[sd].add(s0);
				}
				if(vuelos[s0][sd] == null){
					vuelos[s0][sd] = new Flight(c, t);
				}else{
					Flight actual = new Flight(c, t);
					if(actual.compareTo(vuelos[s0][sd]) < 0)
						vuelos[s0][sd] = actual;
				}								
			}
			
			l = br.readLine();
			int source = map.get(l);
			
			BellmanFord(source, p);
			
			for(int i=0; i<q; i++){
				line = br.readLine().split(" ");
				int sf = map.get(line[0]);
				if(source == sf){
					System.out.println("0 0");
				}else{
					int n = Integer.parseInt(line[1]);
					Flight minimumCost;
					if(n >= p-1)
						minimumCost = A[p-1][sf];
					else
						minimumCost = A[n+1][sf];
					
					if(minimumCost.cost == Integer.MAX_VALUE)
						System.out.println("* *");
					else
						System.out.println(minimumCost.cost+" "+minimumCost.time);						
				}					
			}				
		}		
	}
	
	public static void BellmanFord(int s, int p){
		A = new Flight[p][p];
		A[0][s] = new Flight(0, 0);
		for(int v=0; v<p; v++){
			if(v!=s)
				A[0][v] = new Flight(Integer.MAX_VALUE, Integer.MAX_VALUE);
		}
		
		for(int i=1; i<=p-1; i++){
			for(int v=0; v<p; v++){
				Flight previous = A[i-1][v].clone();
				int inciden = grafoReverse[v].size();
				Flight min = new Flight(Integer.MAX_VALUE, Integer.MAX_VALUE);
				for(int k=0; k<inciden; k++){
					int w = grafoReverse[v].get(k);
					Flight temp = A[i-1][w].clone();
					temp.add(vuelos[w][v]);
					if(temp.compareTo(min) < 0)
						min = temp;
				}
				if(previous.compareTo(min) < 0){
					A[i][v] = previous;
				}else{
					A[i][v] = min;
				}
			}
		}
	}
}

class Flight implements Comparable<Flight>, Cloneable{
	public int cost, time;
	public Flight(int c, int t){
		cost = c;
		time = t;
	}
	
	public int compareTo(Flight f) {
		if(this.cost != f.cost)
			return (this.cost - f.cost);
		else
			return (this.time - f.time);	
	}
	
	public void add(Flight f){
		if(this.cost != Integer.MAX_VALUE && f.cost != Integer.MAX_VALUE){
			this.cost += f.cost;
			this.time += f.time;
		}		
	}	
	
	protected Flight clone(){
		Flight c = new Flight(this.cost, this.time);
		return c;
	}		
}