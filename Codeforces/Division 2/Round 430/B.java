import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] line = br.readLine().split(" ");
		int r = Integer.parseInt(line[0]);
		int d = Integer.parseInt(line[1]);
		
		int n = Integer.parseInt(br.readLine());
		
		if(d == 1) {
			for(int i=0; i<n; i++) {
				br.readLine();
			}
			System.out.println(0);
		}else {
			int count = 0;
			for(int i=0; i<n; i++) {
				line = br.readLine().split(" ");
				int xi = Integer.parseInt(line[0]);
				int yi = Integer.parseInt(line[1]);
				int ri = Integer.parseInt(line[2]);
				int distanceSq = xi*xi + yi*yi;
				if(distanceSq >= (r-d+ri)*(r-d+ri) && distanceSq <= (r-ri)*(r-ri)) {
					count++;
				}
			}
			System.out.println(count);
		}
	}

}
