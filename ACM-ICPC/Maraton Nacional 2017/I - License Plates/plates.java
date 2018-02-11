import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

//Accepted in Competition
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=5180
public class plates {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++){
			char[] s = br.readLine().toCharArray();
			int n = s.length;

			if(n <= 2){
				bw.write("0\n");
				continue;
			}

			HashSet<Character> seen = new HashSet<Character>();

			int[] after = new int[n];
			for(int j=n-1; j>=0; j--){
				after[j] = seen.size();
				seen.add(s[j]);
			}

			HashSet<Character> start = new HashSet<Character>();
			HashSet<String> prefix = new HashSet<String>();
			int total = 0;

			for(int j=0;j<n; j++){
				if(!start.contains(s[j])){
					start.add(s[j]);
					for(int k=j+1; k<n; k++){
						String pref = s[j] + " " + s[k];
						if(!prefix.contains(pref)){
							total += after[k];
							prefix.add(pref);
						}
					}
				}
			}

			bw.write(total + "\n");
		}

		bw.flush();
	}
}
