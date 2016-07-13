import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Problema de la competencia 11 de la RPC 2015
class Doll implements Comparable<Doll>{
	int sz;
	int p;

	public Doll(int s, int price){
		sz = s;
		p = price;
	}

	public int compareTo(Doll o) {
		if(this.sz == o.sz)
			return this.p - o.p;
		else
			return this.sz - o.sz;
	}
}

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		int caso=1;
		while(true){
			String nk[] = scan.readLine().split(" ");

			int n = Integer.parseInt(nk[0]);
			int k = Integer.parseInt(nk[1]);
			if(n==0 && n==k){
			 break;
			}

			Doll dolls[] = new Doll[n];

			for(int t = 0; t < n; t++){
				String desc[] = scan.readLine().split(" ");
				int sz = Integer.parseInt(desc[0]);
				int p = Integer.parseInt(desc[1]);
				Doll d = new Doll(sz, p);
				dolls[t] = d;
			}

			Arrays.sort(dolls);

			long sum = 0;
			for(int i=0; i<k-1; i++){
				sum += (long)dolls[i].sz;
			}

			double minp = Double.POSITIVE_INFINITY;
			for(int i = k-1; i < n; i++){
				double current = (sum+dolls[i].sz)*(double)dolls[i].p/(double)dolls[i].sz;
				if(current < minp) minp = current;
			}

			System.out.println(String.format("Case #%d: %.6f", caso, minp));
			caso++;
		}
	}
}
