import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Accepted in competition
//Available at: https://www.urionlinejudge.com.br/judge/en/problems/view/2702
public class H {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int[] available = new int[3];
		String[] l = new String[3];

		l = br.readLine().split(" ");
		for(int i=0; i<3; i++){
			available[i] = Integer.parseInt(l[i]);
		}

		int total = 0;

		l = br.readLine().split(" ");
		for(int i=0; i<3; i++) {
			int r = Integer.parseInt(l[i]);
			if(r > available[i]) {
				total += (r - available[i]);
			}
		}

		bw.write(total + "\n");
		bw.flush();
	}

}
