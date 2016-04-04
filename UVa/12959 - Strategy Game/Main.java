import java.util.Scanner;

//Problema de la competencia 09 de la RPC 2015
public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);		
		
		while(scan.hasNextLine()){					
			String desc[] = scan.nextLine().split(" ");
			
			int j = Integer.parseInt(desc[0]);			
			int r = Integer.parseInt(desc[1]);
			int players[] = new int[j];
			
			desc = scan.nextLine().split(" ");
			
			int max = 0;
			int maxi = Integer.MIN_VALUE;
			for(int k=0; k<j*r; k++){
				int index = k%j;
				players[index] += Integer.parseInt(desc[k]);
				if(players[index] >= max){
					max = players[index];
					maxi = index;
				}
			}
			
			System.out.println(maxi+1);
		}		
	}
}
