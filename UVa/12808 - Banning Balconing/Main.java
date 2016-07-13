import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for(int i=0; i<n; i++){
			String s[] = sc.nextLine().split(" ");
			double l = Integer.parseInt(s[0]);
			double d = Integer.parseInt(s[1]);
			double h = Integer.parseInt(s[2]);
			double v = Integer.parseInt(s[3]);

			double t = Math.sqrt((2*h)/9810);
			double x = v*t;

			if(x>(d+500) && x<(d+l-500)){
				System.out.println("POOL");
			}else if(x<(d-500) || x>(d+l+500)){
				System.out.println("FLOOR");
			}else{
				System.out.println("EDGE");
			}
		}
	}
}
