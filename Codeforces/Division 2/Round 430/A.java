import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int l = Integer.parseInt(line[0]);
		int r = Integer.parseInt(line[1]);
		int x = Integer.parseInt(line[2]);
		int y = Integer.parseInt(line[3]);
		int k = Integer.parseInt(line[4]);
		
		boolean possible = false;
		
		for(int a=l; a<=r; a++) {
			if(a%k == 0) {
				int b = a/k;
				if(b >= x && b <= y) {
					possible = true;
					break;
				}
			}
		}
		
		if(possible) {
			System.out.println("YES");
		}else {
			System.out.println("NO");
		}
	}
}
