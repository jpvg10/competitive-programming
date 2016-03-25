import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNext()){
			long i,j,ir,jr;			
			i=sc.nextLong();
			j=sc.nextLong();
			
			if(i>j){
				ir=j;
				jr=i;
			}else{
				ir=i;
				jr=j;
			}
			
			long longMax=0;			
			
			for(long k=ir;k<=jr;k++){
				long l=cycleLength(k);
				if(l>longMax){
					longMax=l;
				}
			}
			
			System.out.println(i+" "+j+" "+longMax);
		}
	}
	
	public static long cycleLength(long n){
		long l=1;
		while(n!=1){
			if(n%2==0){
				n=n/2;				
			}else{
				n=(3*n)+1;
			}
			l++;
		}
		return l;
	}
}
