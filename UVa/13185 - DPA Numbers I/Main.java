import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Problema de la competencia 03 de la RPC 2017
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			int divisor = 1;
			int suma = 0;
			while (divisor <= (n / 2)) {
				if (n % divisor == 0) {
					suma += divisor;
				}
				divisor++;
			}
			if (suma > n) {
				System.out.println("abundant");
			} else if (suma == n) {
				System.out.println("perfect");
			} else {
				System.out.println("deficient");
			}
		}
	}
}
