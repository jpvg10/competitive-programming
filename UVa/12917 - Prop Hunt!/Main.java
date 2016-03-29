import java.util.Scanner;

//Problema de la competencia 05 de la RPC 2015
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()){
            int p = sc.nextInt();
            int h = sc.nextInt();
            int o = sc.nextInt();

            if(o-p >= h){
                System.out.println("Props win!");
            }else{
                System.out.println("Hunters win!");
            }
        }		
	}
}
