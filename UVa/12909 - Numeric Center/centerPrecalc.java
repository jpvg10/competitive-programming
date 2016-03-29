import java.util.Scanner;

//Precalcular los centros numéricos
public class centerPrecalc {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double raiz2 = Math.sqrt(2);
		
		long cuadrados[] = new long[10000001];
		long cuadradosPor2[] = new long[10000001];
		
		for(int i=1; i<=10000000; i++){
			cuadrados[i] = (long)Math.pow(i,2);
			cuadradosPor2[i] = (long)Math.pow(i,2)*2;
		}
		
		long n = Long.parseLong(sc.nextLine());
		
		while(n != 0){			
			//int count=0;
			for(int i=2; i<=10000000 && cuadrados[i]<=(n+2); i++){
				int j = (int)Math.floor(i/raiz2);
				if(Math.abs(cuadrados[i]-cuadradosPor2[j])==1){		
					//count++;
					long r;
					r = cuadrados[i]<cuadradosPor2[j]? cuadrados[i] : cuadradosPor2[j];
					System.out.println(r);
				}else if(Math.abs(cuadrados[i]-cuadradosPor2[j+1])==1){
					//count++;
					long r;
					r=cuadrados[i]<cuadradosPor2[j+1]? cuadrados[i] : cuadradosPor2[j+1];
					System.out.println(r);
				}
			}
			//System.out.println(count);
			n = Long.parseLong(sc.nextLine());
		}
	}
}
