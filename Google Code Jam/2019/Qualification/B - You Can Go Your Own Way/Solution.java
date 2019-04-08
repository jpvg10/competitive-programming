import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Accepted in competition for test sets 1, 2 and 3
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			String path = br.readLine();
			StringBuilder solution = new StringBuilder();

			for (int j = 0; j < path.length(); j++) {
				if (path.charAt(j) == 'E') {
					solution.append('S');
				} else {
					solution.append('E');
				}
			}

			System.out.println("Case #" + i + ": " + solution.toString());
		}
	}

}
