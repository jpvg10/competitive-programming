import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class F {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int[] a = new int[n];
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			count.put(a[i], 0);
		}

		int ans = 0;
		int k = -1;

		for(int i=0; i<n; i++) {
			int newValue = 0;
			if(count.containsKey(a[i] - 1)) {
				newValue = count.get(a[i]-1) + 1;
			}else {
				newValue = 1;
			}
			count.put(a[i], newValue);
			if(ans < newValue) {
				ans = newValue;
				k = a[i];
			}
		}

		ArrayList<Integer> out = new ArrayList<Integer>();
		for(int i=n-1; i>=0; i--) {
			if(a[i] == k) {
				out.add(i+1);
				k--;
			}
		}

		System.out.println(ans);
		for(int i=ans-1; i>=0; i--) {
			System.out.print(out.get(i));
			if(i > 0) {
				System.out.print(" ");
			}
		}

		System.out.println();

		sc.close();
	}

}
