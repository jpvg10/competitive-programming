import java.util.Scanner;

public class JumpingMario {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int lowJumps = 0, highJumps = 0;
		int casos = sc.nextInt();
		for(int i=1; i<=casos; i++){
			int walls = sc.nextInt();
			lowJumps = 0;
			highJumps = 0;
			int current = sc.nextInt();
			for(int j=1; j<walls; j++){
				int next = sc.nextInt();
				if(current>next){
					lowJumps++;
				}
				if(current<next){
					highJumps++;
				}
				current=next;
			}
			System.out.println("Case " + i + ": " + highJumps + " " + lowJumps);
		}
	}
}
