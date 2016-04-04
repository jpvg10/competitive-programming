import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());

		for(int i=0; i<t; i++) {
			String l = sc.nextLine();
			int current = 0;
			int score = 0;
			int len = l.length();
			for(int j=0; j<len; j++) {
				if(l.charAt(j) == 'O'){
					current++;
					score = score + current;
				}else{
					current = 0;
				}
			}
			System.out.println(score);
		}
	}
}
