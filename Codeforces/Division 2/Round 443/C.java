import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ones = 1023;
		int zeros = 0;

		int n = Integer.parseInt(br.readLine());

		for(int i=0; i<n; i++) {
			String[] l = br.readLine().split(" ");
			char c = l[0].charAt(0);
			int x = Integer.parseInt(l[1]);

			if(c == '^') {
				ones ^= x;
				zeros ^= x;
			}else if(c == '&') {
				ones &= x;
				zeros &= x;
			}else {
				ones |= x;
				zeros |= x;
			}
		}

		int or = 0;
		int and = 1023;
		int xor = 0;
		for(int i=0; i<10; i++) {
			if((zeros&(1<<i)) != 0 && (ones&(1<<i)) != 0) {
				or |= (1<<i);
			}else if((zeros&(1<<i)) == 0 && (ones&(1<<i)) == 0) {
				and ^= (1<<i);
			}else if((zeros&(1<<i)) != 0) {
				xor |= (1<<i);
			}
		}

		System.out.println("3");
		System.out.println("| " + or);
		System.out.println("& " + and);
		System.out.println("^ " + xor);
	}

}
