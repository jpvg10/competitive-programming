import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		boolean good = false;

		for(int i=0; i<n; i++){
			String in[] = br.readLine().split(" ");
			int before = Integer.parseInt(in[1]);
			int after = Integer.parseInt(in[2]);
			if(before >= 2400 && after > before){
				good = true;
				break;
			}
		}

		if(good) System.out.println("YES");
		else System.out.println("NO");
	}

}
