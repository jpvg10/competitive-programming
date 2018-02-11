import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int maxNotSquare = Integer.MIN_VALUE;

		String[] a = br.readLine().split(" ");

		for(int i=0; i<n; i++){
			int x = Integer.parseInt(a[i]);
			int s = (int) Math.sqrt(x);
			if((x < 0 && x > maxNotSquare) || (s*s != x && x > maxNotSquare)){
				maxNotSquare = x;
			}
		}

		System.out.println(maxNotSquare);
	}

}
