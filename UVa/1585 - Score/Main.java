import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());
		
        for(int i=0; i<n; i++){
			String l = sc.nextLine();
			int acumula = 0;
			int score = 0;
            int len = l.length();
			for(int j=0; j<len; j++){
				if(l.charAt(j)=='O'){					
					acumula++;
					score = score+acumula;					
				}else{
					acumula=0;
				}
            }
            System.out.println(score);
		}
	}
}
