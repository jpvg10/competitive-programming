import java.util.Scanner;
import java.util.HashSet;

public class Main {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int n = Integer.parseInt(sc.nextLine());

		for(int i=1; i<=n; i++){
			String l[] = sc.nextLine().split(" ");
			int a = Integer.parseInt(l[0]);
			int b = Integer.parseInt(l[1]);
			String la[] = new String[a];
			String lb[] = new String[b];
			HashSet<String> set = new HashSet<String>();
			int palabras = 0;
			for(int j=0; j<a; j++){
				la[j] = sc.nextLine();
			}
			for(int j=0; j<b; j++){
				lb[j] = sc.nextLine();
			}
			for(int x=0; x<a; x++){
				for(int y=0; y<b; y++){
					String g = la[x]+lb[y];
					if(!set.contains(g)){
						set.add(g);
						palabras++;
					}
				}
			}
			System.out.println("Case "+i+": "+palabras);
		}
	}
}