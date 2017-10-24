import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

// It is necessary to use BufferedReader and BufferedWriter
public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] l = br.readLine().split(" ");

		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);

		int[] c = new int[n];
		l = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			c[i] = Integer.parseInt(l[i]);
		}

		PriorityQueue<Flight> pq = new PriorityQueue<>();

		for(int i=0; i<k; i++) {
			pq.add(new Flight(i, c[i]));
		}

		long totalCost = 0;
		int[] departure = new int[n];

		for(int i=k; i<k+n; i++) {
			if(i < n) {
				pq.add(new Flight(i, c[i]));
			}
			Flight current = pq.poll();
			totalCost += (long) (i - current.originalTime) * current.delayCost;
			departure[current.originalTime] = (i+1);
		}

		bw.write(totalCost + "\n");
		for(int i=0; i<n; i++) {
			bw.write(departure[i] + "");
			if(i < n-1) bw.write(" ");
			else bw.write("\n");
		}

		bw.flush();
	}

}

class Flight implements Comparable<Flight> {
	public int originalTime, delayCost;
	public Flight(int originalTime, int delayCost) {
		this.originalTime = originalTime;
		this.delayCost = delayCost;
	}
	@Override
	public int compareTo(Flight o) {
		return o.delayCost - this.delayCost;
	}
}
