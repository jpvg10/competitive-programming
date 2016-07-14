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
			
			int previous = 0, current = 1, max = -1;
			
			for(int i=1; i<n; i++){
				if(v[i]>=v[i-1]){
					current++;					
				}else{
					max = max<(previous+current)?(previous+current):max;
					previous = current;
					current = 1;
				}
			}	
			
			max = max<(previous+current)?(previous+current):max;			
			
			System.out.println(max);						
		}
		sc.close();
	}
}
