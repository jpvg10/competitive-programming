import java.util.Scanner;

 public class Main {
 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextLine()){
			int n = Integer.parseInt(sc.nextLine());
			
			int capacidad[] = new int[n];
			boolean externos[] = new boolean[n];
			int cajas[] = new int[n];			
 
			for(int c=0; c<n; c++){
				cajas[c] = Integer.parseInt(sc.nextLine());
			}		
 
			externos[0] = true;		
			capacidad[0] = cajas[0]; 
			
			cyclecajas:for(int j=1; j<n; j++){
				capacidad[j] = cajas[j];
				for(int cap=0; cap<=j; cap++){					
					if(cap<j){
						if(capacidad[cap]>=cajas[j]){
							capacidad[cap] -= cajas[j];
							continue cyclecajas;
						}	
					}else{
						capacidad[cap] = cajas[j];
						externos[j] = true;
						break;
					} 
				}
			}
 
			int altura = 0;
			for(int k=0; k<n; k++){
				if(externos[k]) 
					altura += cajas[k];
			}
			System.out.println(altura);
			
			//Blank Line
			if(sc.hasNextLine())
				sc.nextLine(); 
		}		
	} 
}
