import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//Accepted in UVa
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4826
public class texting {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		boolean first = true;

		String l;
		while((l = br.readLine()) != null){
			if(first){
				first = false;
			}else{
				bw.write("*\n");
			}

			String s[] = l.split(" ");
			int n = s.length+2;
			int p[] = new int[s.length];
			int degree[] = new int[n];
			Arrays.fill(degree, 1);

			boolean error = false;

			for(int i=0; i<n-2; i++){
				p[i] = Integer.parseInt(s[i]);
				if(p[i] > n-1){
					error = true;
					break;
				}
				degree[p[i]]++;
			}

			if(error){
				bw.write("impossible\n");
			}else{
				ArrayList<Integer> g[] = new ArrayList[n];
				for(int i=0; i<n; i++){
					g[i] = new ArrayList<Integer>();
				}

				int x = 0;
				while(degree[x] != 1) {
					x++;
				}
				int index = x;

				for(int i=0; i<n-2; i++) {
					int y = p[i];
					g[x].add(y);
					g[y].add(x);
					degree[y]--;
					if(y < index && degree[y] == 1) {
						x = y;
					}else {
						x = index + 1;
						while(degree[x] != 1) {
							x++;
						}
						index = x;
					}
				}

				for(int i=index+1; i<n; i++) {
					if(degree[i] == 1) {
						g[x].add(i);
						g[i].add(x);
						break;
					}
				}

				bw.write(n + "\n");

				for(int i=0; i<n; i++){
					Collections.sort(g[i]);
					for(int j=0; j<g[i].size(); j++){
						bw.write(Integer.toString(g[i].get(j)));
						if(j < g[i].size() - 1) bw.write(" ");
					}
					bw.write("\n");
				}
			}
		}

		bw.flush();
	}
}
