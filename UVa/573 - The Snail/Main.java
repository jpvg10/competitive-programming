import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l = br.readLine()) != null ){
			String s[] = l.split(" ");
			int h = Integer.parseInt(s[0]);
			int u = Integer.parseInt(s[1]);
			int d = Integer.parseInt(s[2]);
			int f = Integer.parseInt(s[3]);

			if(h == 0) break;

			double fatigue = (u*f)/100.0;

			int day = -1;
			double start = 0;
			double climbed = 0;
			double heightAfter = 0;

			while(heightAfter <= h && start >= 0){
				day++;
				climbed = u - fatigue*day;
				if(climbed > 0){
					heightAfter = start + climbed;
				}else{
					heightAfter = start;
				}
				start = heightAfter - d;
			}

			day++;

			if(heightAfter > h ){
				System.out.println("success on day " + day);
			}else{
				System.out.println("failure on day " + day);
			}
		}

	}

}
