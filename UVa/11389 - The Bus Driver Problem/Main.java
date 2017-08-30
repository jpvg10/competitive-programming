import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String l;
		while((l = br.readLine()) != null) {
			if(l.equals("0 0 0")) break;
			String[] line = l.split(" ");
			int n = Integer.parseInt(line[0]);
			int d = Integer.parseInt(line[1]);
			int r = Integer.parseInt(line[2]);
			int[] morning = new int[n];
			int[] afternoon = new int[n];
			line = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				morning[i] = Integer.parseInt(line[i]);
			}
			line = br.readLine().split(" ");
			for(int i=0; i<n; i++) {
				afternoon[i] = Integer.parseInt(line[i]);
			}
			Arrays.sort(morning);
			Arrays.sort(afternoon);
			int extraHours = 0;
			for(int i=0; i<n; i++) {
				int length = morning[i] + afternoon[n-1-i];
				if(length > d) extraHours += (length - d);
			}
			System.out.println(r * extraHours);
		}
	}
}
