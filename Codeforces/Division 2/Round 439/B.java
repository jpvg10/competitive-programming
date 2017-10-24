import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long a = sc.nextLong();
		long b = sc.nextLong();

		if(b - a >= 5) {
			System.out.println(0);
		}else {
			long ans = 1;
			for(long i=a+1; i<=b; i++) {
				ans = (ans * (i%10)) % 10;
			}
			System.out.println(ans);
		}

		sc.close();
	}

}
