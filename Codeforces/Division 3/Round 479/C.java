import java.util.Arrays;
import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		Integer[] a = new Integer[n];
		for(int i=0; i<n; i++){
			a[i] = sc.nextInt();
		}

		Arrays.sort(a);

		if(k == 0){
			if(a[0] > 1){
				System.out.println(a[0] - 1);
			}else{
				System.out.println("-1");
			}
		}else if(k == n){
			if(a[k-1] <= 1000000000){
				System.out.println(a[k-1]);
			}else{
				System.out.println("-1");
			}
		}else{
			int ans = a[k-1];
			if(a[k] == ans){
				System.out.println("-1");
			}else{
				System.out.println(ans);
			}
		}

		sc.close();
	}

}
