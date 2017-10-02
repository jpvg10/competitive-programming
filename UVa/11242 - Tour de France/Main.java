import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(sc.hasNextInt()) {
			int f = sc.nextInt();
			if(f == 0) break;
			int r = sc.nextInt();

			int frontCluster[] = new int[f];
			for(int i=0; i<f; i++) {
				frontCluster[i] = sc.nextInt();
			}

			int rearCluster[] = new int[r];
			for(int i=0; i<r; i++) {
				rearCluster[i] = sc.nextInt();
			}

			Pair pairs[] = new Pair[f*r];
			int k = 0;

			for(int i=0; i<f; i++) {
				for(int j=0; j<r; j++) {
					pairs[k] = new Pair(frontCluster[i], rearCluster[j]);
					k++;
				}
			}

			Arrays.sort(pairs);

			double maxSpread = 0;

			for(int i=0; i<pairs.length-1; i++) {
				Pair a = pairs[i];
				Pair b = pairs[i+1];
				double spread = b.ratio/a.ratio;
				if(spread > maxSpread) {
					maxSpread = spread;
				}
			}

			System.out.format(Locale.US, "%.2f\n", maxSpread);
		}

		sc.close();
	}
}

class Pair implements Comparable<Pair> {
	int front, rear;
	double ratio;

	public Pair(int front, int back) {
		this.front = front;
		this.rear = back;
		this.ratio = (double)back/(double)front;
	}

	public int compareTo(Pair p) {
		if(this.ratio < p.ratio) {
			return -1;
		}else {
			return 1;
		}
	}
}