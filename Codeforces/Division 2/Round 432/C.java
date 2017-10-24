import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		
		int n = Integer.parseInt(br.readLine());
		Point5[] points = new Point5[n];
		
		for(int i=0; i<n; i++) {
			String[] l = br.readLine().split(" ");
			points[i] = new Point5(l);
		}
		
		boolean[] bad = new boolean[n];
		int count = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<n && !bad[i]; j++) {
				for(int k=0; k<n && !bad[i]; k++) {
					if(i != j && j != k && i != k) {
						if(VectorHelper.isBad(points[i], points[j], points[k])) {
							bad[i] = true;
							count++;
						}
					}
				}					
			}
		}
		
		System.out.println(n-count);
		for(int i=0; i<n; i++) {
			if(!bad[i]) {
				System.out.println(i+1);
			}
		}
	}

}

class Point5 {
	int[] v;	
	public Point5(String[] l){
		v = new int[5];
		for(int i=0; i<5; i++) {
			v[i] = Integer.parseInt(l[i]);
		}
	}
}

class VectorHelper {	
	private static double magnitude(int[] x) {
		double m = 0;
		for(int i=0; i<5; i++) {
			m += x[i]*x[i];
		}
		return Math.sqrt(m);
	}
	
	private static double angle(int[] ab, int[] ac) {
		double theta = 0;
		for(int i=0; i<5; i++) {
			theta += ab[i]*ac[i];
		}
		theta = theta / (magnitude(ab)*magnitude(ac));
		return Math.acos(theta);
	}
	
	public static boolean isBad(Point5 a, Point5 b, Point5 c) {
		int[] ab = new int[5];
		int[] ac = new int[5];
		
		for(int i=0; i<5; i++) {
			ab[i] = b.v[i] - a.v[i];
			ac[i] = c.v[i] - a.v[i];
		}
		
		double angle = angle(ab, ac);
		return angle < (Math.PI/2);		
	}
}
