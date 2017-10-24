import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();

		if(n == k || k == 0) {
			System.out.println("0 0");
		}else {
			int limit = n/3;
			int max;
			if(n%3 == 0) {
				if(k <= limit) {
					max = 2*k;
				}else {
					max = n-k;
				}
			}else if(n%3 == 1) {
				if(k <= limit) {
					max = 2*k;
				}else if(k == limit + 1){
					max = 2*limit;
				}else {
					max = n-k;
				}
			}else {
				if(k <= limit) {
					max = 2*k;
				}else if(k == limit + 1) {
					max = 2*limit + 1;
				}else {
					max = n-k;
				}
			}

			System.out.print("1 " + max);
		}

		sc.close();
	}
}
