import java.util.Arrays;
import java.util.Scanner;

//Accepted
public class fnets {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		while(sc.hasNextLine()){
			String s[] = sc.nextLine().split(" ");
			int n = Integer.parseInt(s[0]);
			int v[] = new int[n];				
			
			for(int i=1; i<=n; i++)
				v[i-1] = Integer.parseInt(s[i]);									
			
			boolean possible = true;				
			
			int degree[] = sortReverse(v);
			
			for(int i=0; i<n; i++){
				int a = degree[0];				
				for(int j=1; j<a+1; j++){
					degree[j]--;
					degree[0]--;
				}			
				degree = bubble(degree);
			}			
			
			for(int i=0; i<n; i++){
				if(degree[i] != 0){
					possible = false;
					break;
				}
			}								
			System.out.println(possible?1:0);				
		}
		sc.close();		
	}
	
	public static int[] sortReverse(int v[]){
		Arrays.sort(v);
		int r[] = new int[v.length];
		for(int i=0;i<v.length;i++)
			r[i]=v[v.length-i-1];
		return r;
	}
	
	public static int[] bubble(int v[]){		
		boolean change = true;
		for(int i=0; i<v.length && change; i++){
			change = false;
			for(int j=0; j<v.length-i-1; j++){
				if(v[j]<v[j+1]){
					int t = v[j];
					v[j] = v[j+1];
					v[j+1] = t;
					change = true;
				}					
			}
		}
		return v;
	}
}
