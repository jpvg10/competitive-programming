import java.util.Scanner;

public class C {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		String l[] = sc.nextLine().split(" ");
		long x1 = Integer.parseInt(l[0]);
		long y1 = Integer.parseInt(l[1]);

		l = sc.nextLine().split(" ");
		long x2 = Integer.parseInt(l[0]);
		long y2 = Integer.parseInt(l[1]);

		int n = Integer.parseInt(sc.nextLine());
		int lineas = 0;

		for(int i=0; i<n; i++){
			l = sc.nextLine().split(" ");
			long a = Integer.parseInt(l[0]);
			long b = Integer.parseInt(l[1]);
			long c = Integer.parseInt(l[2]);

			long d = (a*x1) + (b*y1) + c;
			long e = (a*x2) + (b*y2) + c;

			if((d<0 && e>0)||(d>0 && e<0)){
				lineas++;
			}
		}

		System.out.println(lineas);
	}
}
