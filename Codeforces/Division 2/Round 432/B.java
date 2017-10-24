import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] line = br.readLine().split(" ");
		
		long ax = Long.parseLong(line[0]);
		long ay = Long.parseLong(line[1]);
		long bx = Long.parseLong(line[2]);
		long by = Long.parseLong(line[3]);
		long cx = Long.parseLong(line[4]);
		long cy = Long.parseLong(line[5]);
		
		long d1 = (bx-ax)*(bx-ax) + (by-ay)*(by-ay);
		long d2 = (cx-bx)*(cx-bx) + (cy-by)*(cy-by);
		long det = ax*(by-cy) + bx*(cy-ay) + cx*(ay-by);
		
		if(d1 == d2 && det != 0) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
}
