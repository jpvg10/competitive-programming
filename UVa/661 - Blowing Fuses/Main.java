import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String l = sc.nextLine();
		int k = 1;
		while(!l.equals("0 0 0")){			
			String s[] = l.split(" ");
			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			
			int devices[] = new int[n];
			boolean turned[] = new boolean[n];
			
			for(int i=0; i<n; i++){
				devices[i] = Integer.parseInt(sc.nextLine());
			}
			
			int currentLoad = 0, max = 0;
			
			for(int i=0; i<m; i++){
				currentLoad = 0;
				int op = Integer.parseInt(sc.nextLine());
				turned[op-1] = !turned[op-1];
				for(int j=0; j<n; j++){
					if(turned[j]){
						currentLoad += devices[j];
					}
				}
				if(currentLoad>max){
					max = currentLoad;
				}
			}
			
			if(max>c){
				System.out.println("Sequence " + k + "\nFuse was blown.");
			}else{
				System.out.println("Sequence " + k + "\nFuse was not blown.\nMaximal power consumption was " + max + " amperes.");
			}	
			System.out.println();
			k++;
			l = sc.nextLine();
		}
	}
}
