import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);		
		
		int t = sc.nextInt();
		
		for(int i=0; i<t; i++) {			
			int manhattan[][] = new int[1024][1024];
			int d = sc.nextInt();
			int n = sc.nextInt();			
									
			int maxX = 0;
			int maxY = 0;
			int maxKill = 0;
			
			for(int j=0; j<n; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int size = sc.nextInt();
				for(int a=x-d; a<=x+d; a++) {
					for(int b=y-d; b<=y+d; b++) {
						if(a >= 0 && b >= 0 && a < 1024 && b < 1024) {
							manhattan[a][b] += size;
							if(manhattan[a][b] > maxKill) {
								maxKill = manhattan[a][b];
								maxX = a;
								maxY = b;
							}
						}
					}
				}
			}

			System.out.println(maxX + " " + maxY + " " + maxKill);
		}
	}
}
