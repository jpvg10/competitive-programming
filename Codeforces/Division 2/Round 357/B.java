import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		boolean ok = false;

		int maxa = (n - 1234)/1234567 + 1;
		int maxb = (n - 1234)/123456 + 1;

		for(int a=0; a<=maxa && !ok; a++){
			for(int b=0; b<=maxb && !ok; b++){
				int c = n - 1234567*a - 123456*b;
				int div = c / 1234;
				if(div < 0) break;
				if(c % 1234 == 0){
					ok = true;
				}
			}
		}

		if(ok) System.out.println("YES");
		else System.out.println("NO");
	}

}
