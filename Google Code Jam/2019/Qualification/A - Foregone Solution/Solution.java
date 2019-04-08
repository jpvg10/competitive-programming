import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

// Accepted in competition for test sets 1 and 2
// Here using BigInteger to pass test set 3
public class Solution {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++) {
			char[] n = br.readLine().toCharArray();
			char[] solution = new char[n.length];
			Arrays.fill(solution, '0');
			
			for(int j=0; j<n.length; j++) {
				if(n[j] == '4') {
					n[j] = '3';
					solution[j] = '1';
				}
			}
			
			BigInteger a = new BigInteger(String.valueOf(n), 10);
			BigInteger b = new BigInteger(String.valueOf(solution), 10);
			
			System.out.println("Case #" + i + ": " + a + " " + b);
		}
	}

}
