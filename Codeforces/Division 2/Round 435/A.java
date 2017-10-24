import java.util.Arrays;
import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();
		int[] set = new int[n];
		for(int i=0; i<n; i++) {
			set[i] = sc.nextInt();
		}

		Arrays.sort(set);

		int index = Arrays.binarySearch(set, x);

		int ans;
		if(index < 0) {
			index = -1*(index+1);
			ans = x - index;
		}else {
			ans = x - index + 1;
		}

		System.out.println(ans);
		sc.close();
	}
}
