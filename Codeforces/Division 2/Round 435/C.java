import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int x = sc.nextInt();

		if(n == 1) {
			System.out.println("YES");
			System.out.println(x);
		}else if(n == 2) {
			if(x == 0) {
				System.out.println("NO");
			}else {
				int z = 1^x;
				System.out.println("YES");
				System.out.println(1 + " " + z);
			}
		}else {
			System.out.println("YES");
			int pw = 1<<17;
			int xor = 0;
			for(int i=1; i<=n-3; i++) {
				System.out.print(i + " ");
				xor = xor ^ i;
			}
			if(xor == x) {
				int z = pw^(2*pw);
				System.out.print(pw + " ");
				System.out.print(2*pw + " ");
				System.out.print(z + " ");
			}else {
				int z = pw^xor^x;
				System.out.print(0 + " ");
				System.out.print(pw + " ");
				System.out.print(z + " ");
			}
		}

		sc.close();
	}

}
