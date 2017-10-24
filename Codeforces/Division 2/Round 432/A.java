import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		String[] l = br.readLine().split(" ");
		
		int n = Integer.parseInt(l[0]);
		int k = Integer.parseInt(l[1]);
		int t = Integer.parseInt(l[2]);
		
		if(t < k) {
			System.out.println(t);
		}else if(t <= n) {
			System.out.println(k);
		}else {
			System.out.println(k - t + n);
		}		
	}
}
