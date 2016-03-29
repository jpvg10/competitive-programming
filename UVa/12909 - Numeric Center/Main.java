import java.util.Scanner;

//Problema de la competencia 05 de la RPC 2015
//Fue necesario precalcular
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long centers[] = {8, 49, 288, 1681, 9800,	57121, 332928, 1940449, 11309768, 65918161, 384199200, 2239277041L, 
						13051463048L, 76069501249L,	443365544448L, 2584123765441L, 15061377048200L, 87784138523761L};
		
        long n = Long.parseLong(sc.nextLine());
		
        while(n != 0){
			int count = 0;
			for(int i=0; i<18; i++){
				if(centers[i]<=n){
					count++;
				}
			}
			System.out.println(count);
			
			n = Long.parseLong(sc.nextLine());
		}
	}
}
