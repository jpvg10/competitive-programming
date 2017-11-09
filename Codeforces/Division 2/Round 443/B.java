import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] l = br.readLine().split(" ");

		int n = Integer.parseInt(l[0]);
		long k = Long.parseLong(l[1]);

		LinkedList<Integer> power = new LinkedList<Integer>();

		l = br.readLine().split(" ");

		int maxPower = -1;

		for(int i=0; i<n; i++) {
			int p = Integer.parseInt(l[i]);
			power.addLast(p);
			if(p > maxPower) {
				maxPower = p;
			}
		}

		if(k >= (long)n-1) {
			System.out.println(maxPower);
		}else {
			int a = power.get(0);
			int b = power.get(1);
			if(a < b) {
				power.remove(1);
				power.addFirst(b);
			}

			int consecutive = 0;
			while(consecutive < k) {
				a = power.get(0);
				b = power.get(1);
				if(a < b) {
					power.remove(0);
					power.addLast(a);
					consecutive = 1;
				}else {
					power.remove(1);
					power.addLast(b);
					consecutive++;
				}
			}

			System.out.println(power.peekFirst());
		}
	}

}
