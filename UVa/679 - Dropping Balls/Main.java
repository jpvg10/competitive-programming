import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();	
				
		for(int i=0; i<t; i++){
			int d = sc.nextInt();
			int b = sc.nextInt();
			b--;
			int leaf = 1;
			while(leaf < Math.pow(2, d-1)){
				if(b%2 == 0){
					leaf = leaf*2;
				}else{
					leaf = leaf*2 + 1;
				}
				b = b/2;
			}
			System.out.println(leaf);
		}		
		sc.close();
	}
}
