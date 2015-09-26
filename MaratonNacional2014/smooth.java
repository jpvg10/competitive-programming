import java.util.Scanner;

//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4653
public class smooth {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextInt()){
			int n = sc.nextInt();
			int v[] = new int[n];
			
			for(int i=0; i<n; i++)
				v[i] = sc.nextInt();			
			
			int anterior = 0, actual = 1, maximo = -1;
			
			for(int i=1; i<n; i++){
				if(v[i]>=v[i-1]){
					actual++;					
				}else{	
					maximo = maximo<(anterior+actual)?(anterior+actual):maximo;
					anterior = actual;
					actual = 1;
				}
			}	
			
			maximo = maximo<(anterior+actual)?(anterior+actual):maximo;			
			
			System.out.println(maximo);						
		}
		sc.close();
	}
}
