import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;

// Accepted in practice mode for test sets 1 and 2
public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for (int i = 1; i <= t; i++) {
			String[] line = br.readLine().split(" ");
			int l = Integer.parseInt(line[1]);

			BigInteger[] cipher = new BigInteger[l];
			line = br.readLine().split(" ");
			for (int j = 0; j < l; j++) {
				cipher[j] = new BigInteger(line[j]);
			}

			int k = 0;
			while (cipher[k].equals(cipher[k + 1])) {
				k++;
			}

			BigInteger[] plain = new BigInteger[l + 1];
			BigInteger common = gcd(cipher[k], cipher[k + 1]);

			plain[k] = cipher[k].divide(common);
			plain[k + 1] = common;

			for (int j = k - 1; j >= 0; j--) {
				plain[j] = cipher[j].divide(plain[j + 1]);
			}

			for (int j = k + 2; j <= l; j++) {
				plain[j] = cipher[j - 1].divide(plain[j - 1]);
			}

			BigInteger[] sortedPrimes = plain.clone();
			Arrays.sort(sortedPrimes);

			HashMap<BigInteger, Character> map = new HashMap<>();
			char current = 'A';
			for (BigInteger sp : sortedPrimes) {
				if (!map.containsKey(sp)) {
					map.put(sp, current);
					current++;
				}
			}

			StringBuilder ans = new StringBuilder();
			for (BigInteger p : plain) {
				ans.append(map.get(p));
			}

			System.out.println("Case #" + i + ": " + ans);
		}

	}

	public static BigInteger gcd(BigInteger a, BigInteger b) {
		while (!b.equals(BigInteger.ZERO)) {
			BigInteger t = b;
			b = a.mod(b);
			a = t;
		}
		return a;
	}

}
