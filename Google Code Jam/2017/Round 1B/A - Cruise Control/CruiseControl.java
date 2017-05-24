import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

//Accepted in competition for the Small and Large datasets
public class CruiseControl {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=1; i<=t; i++){
			String l[] = br.readLine().split(" ");
			int d = Integer.parseInt(l[0]);
			int n = Integer.parseInt(l[1]);
			double longestTime = -1;
			for(int j=0; j<n; j++){
				l = br.readLine().split(" ");
				int k = Integer.parseInt(l[0]);
				int s = Integer.parseInt(l[1]);
				double time = (double)(d-k)/(double)s;
				if(time > longestTime) longestTime = time;
			}
			double speed = d / longestTime;
			System.out.format(Locale.US, "Case #%d: %.6f\n", i, speed);
		}

	}

}
