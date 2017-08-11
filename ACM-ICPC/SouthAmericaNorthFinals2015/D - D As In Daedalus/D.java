import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted in competition
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=866&page=show_problem&problem=4895
public class D {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String in;

		while ((in = br.readLine()) != null) {
			String s[] = in.split(" ");

			int n = Integer.parseInt(s[0]);
			int m = Integer.parseInt(s[1]);

			int cards[] = { 1, 10, 100, 1000, 10000 };

			int won = 0;
			int possible = 0;

			for (int i = 0; i < m; i++) {
				s = br.readLine().split(" ");
				int b = Integer.parseInt(s[0]);
				int daedalus = Integer.parseInt(s[1]);
				int pr = 0;

				for (int j = 2; j < s.length; j++) {
					pr += Integer.parseInt(s[j]);
				}

				if (pr + daedalus <= b) {
					won += daedalus;
					int best = -1;
					for (int k = 0; k < 5; k++) {
						if (pr + cards[k] >= pr + daedalus
								&& pr + cards[k] <= b)
							best = cards[k];
					}
					if (best != -1) {
						possible += best;
					}
				} else {
					int best = -1;
					for (int k = 0; k < 5; k++) {
						if (pr + cards[k] <= b) {
							best = cards[k];
						}
					}
					if (best != -1) {
						possible += best;
					}
				}
			}
			if (possible > won) {
				System.out.println(possible - won);
			} else {
				System.out.println(0);
			}
		}
	}
}