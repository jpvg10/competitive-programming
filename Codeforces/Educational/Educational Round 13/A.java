import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String in[] = br.readLine().split(" ");
		int n = Integer.parseInt(in[0]);
		int k = Integer.parseInt(in[1]);

		int x = (n/k + 1) * k;

		System.out.println(x);
	}

}
