import java.util.Scanner;

//Problema de la competencia 09 de la RPC 2015
public class Main {
    
	public static void main(String args[]){
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			String[] x = sc.nextLine().split(" ");
			if(Integer.parseInt(x[0])>=Integer.parseInt(x[1])){
				System.out.println(x[0]);
			}else{
				System.out.println(x[1]);
			}
		}
	}	
}
