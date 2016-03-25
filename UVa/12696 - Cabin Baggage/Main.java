import java.util.*;

class Main {
	public static void main (String[] args){
		Scanner sc = new Scanner(System.in);
		
		int n = (int)sc.nextDouble();
		
		double length, width, depth, weight;
		
		int allowed = 0;
		
		for(int i=0; i<n; i++){
			length = sc.nextDouble();
			width = sc.nextDouble();
			depth = sc.nextDouble();
			weight = sc.nextDouble();
			
			if(weight <= 7.0 && ((length <= 56.0 && width <= 45.0 && depth <= 25.0) || (length+width+depth) <= 125.0)){
				System.out.println(1);
				allowed++;
			}else{
				System.out.println(0);
			}
		}
		System.out.println(allowed);
	}
}