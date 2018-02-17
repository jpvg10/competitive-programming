import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		int[] a = new int[n];

		String[] l = sc.nextLine().split(" ");
		for(int i=0; i<n; i++) {
			a[i] = Integer.parseInt(l[i]);
		}

		char[] s = sc.nextLine().toCharArray();

		for(int i=0; i<n-1; i++) {
			int j = i;
			if(s[i] == '1') {
				while(j<n-1 && s[j] == '1') {
					j++;
				}
				Arrays.sort(a, i, j+1);
			}
			i = j;
		}

		boolean sorted = true;
		for(int i=1; i<n; i++) {
			if(a[i] < a[i-1]) {
				sorted = false;
				break;
			}
		}

		if(sorted) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}

		sc.close();
	}

}
