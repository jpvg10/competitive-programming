import java.util.Scanner;

//Problema de la competencia 05 de la RPC 2015
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		
		for(int i=0; i<t; i++){
			String s[] = sc.nextLine().split(" ");
			long n = Long.parseLong(s[0]);
			long m = Long.parseLong(s[1]);
			long r = n*(2*m-n-1)/2;
			System.out.println(r);
		}
	}
}
