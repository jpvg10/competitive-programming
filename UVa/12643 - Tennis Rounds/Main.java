import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		while(sc.hasNextLine()){
			String l[]=sc.nextLine().split(" ");
			int n=Integer.parseInt(l[0]);
			int i=Integer.parseInt(l[1]);
			int j=Integer.parseInt(l[2]);

			int x=0;

			do{
				i=(i+1)/2;
				j=(j+1)/2;
				x++;
			}while(i!=j);

			System.out.println(x);
		}
	}
}
