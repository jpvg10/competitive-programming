import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a, b;
		if(n%2 == 0) {
			a = n/2 - 1;
			b = n/2 + 1;
		}else {
			a = n/2;
			b = n/2 + 1;
		}

		while(a>0 && b<n) {
			if(mcd(a, b) == 1) {
				break;
			}
			a--;
			b++;
		}

		System.out.println(a + " " + b);

		sc.close();
	}

	public static int mcd(int a, int b){
		while(b != 0){
			int t = b;
			b = a % b;
			a = t;
		}
		return a;
	}

}
