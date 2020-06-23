import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PlayOnWords {
	static boolean[][] G;
	static boolean[] seen;
	static int[] in, out;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			int n = Integer.parseInt(br.readLine());

			G = new boolean[26][26];
			seen = new boolean[26];
			in = new int[26];
			out = new int[26];

			for(int i=0; i<n; i++) {
				String w = br.readLine();
				int s = w.charAt(0) - 'a';
				int e = w.charAt(w.length() - 1) - 'a';
				in[e]++;
				out[s]++;
				G[s][e] = true;
				G[e][s] = true;
			}

			boolean possible = true;
			int components = allDfs();

			if(components > 1) {
				possible = false;
			}

			int inMinusOut = 0;
			int outMinusIn = 0;

			for(int i=0; i<26 && possible; i++) {
				if(in[i] != out[i]) {
					int dif = in[i] - out[i];
					if(dif == 1) {
						inMinusOut++;
					} else if (dif == -1) {
						outMinusIn++;
					} else {
						possible = false;
					}
				}
			}

			if(possible && inMinusOut <= 1 && outMinusIn <= 1) {
				System.out.println("Ordering is possible.");
			} else {
				System.out.println("The door cannot be opened.");
			}
		}

	}

	public static int allDfs() {
		int components = 0;

		for(int i=0; i<26; i++) {
			if (!seen[i] && (in[i] != 0 || out[i] != 0)) {
				dfs(i);
				components++;
			}
		}

		return components;
	}

	public static void dfs(int u) {
		seen[u] = true;
		for(int v=0; v<26; v++) {
			if(G[u][v] && !seen[v]) {
				dfs(v);
			}
		}
	}
}
