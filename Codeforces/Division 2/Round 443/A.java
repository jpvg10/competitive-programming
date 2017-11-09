import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		int[] s = new int[n];
		int[] d = new int[n];

		for(int i=0; i<n; i++) {
			String[] l = br.readLine().split(" ");
			s[i] = Integer.parseInt(l[0]);
			d[i] = Integer.parseInt(l[1]);
		}

		int last = s[0];

		for(int i=1; i<n; i++) {
			if(s[i] > last) {
				last = s[i];
			}else {
				int k = (int) Math.ceil((double)(last - s[i]) / d[i]);
				if(s[i] + k*d[i] == last) k++;
				last = s[i] + k*d[i];
			}
		}

		System.out.println(last);
	}

}
