import java.util.Scanner;

public class A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s[] = sc.nextLine().split(" ");
		int momentos = Integer.parseInt(s[0]);
		int boton = Integer.parseInt(s[1]);

		int minutosTotales = 0;
		int actual = 1;

		for(int i=0; i<momentos; i++){
			String x[] = sc.nextLine().split(" ");
			int l = Integer.parseInt(x[0]);
			int r = Integer.parseInt(x[1]);

			while(actual <= l){
				actual = actual+boton;
			}
			actual = actual-boton;

			if(actual != l){
				minutosTotales += l-actual;
			}

			minutosTotales += r-l+1;
			actual = r+1;
		}

		System.out.println(minutosTotales);
	}

}
