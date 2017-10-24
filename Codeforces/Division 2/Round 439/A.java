import java.util.HashSet;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];

		HashSet<Integer> present = new HashSet<Integer>();

		for(int i=0; i<n; i++) {
			x[i] = sc.nextInt();
			present.add(x[i]);
		}

		for(int i=0; i<n; i++) {
			y[i] = sc.nextInt();
			present.add(y[i]);
		}

		int count = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				int xor = x[i]^y[j];
				if(present.contains(xor)) {
					count++;
				}
			}
		}

		if(count % 2 == 0) {
			System.out.println("Karen");
		}else {
			System.out.println("Koyomi");
		}

		sc.close();
	}

}
