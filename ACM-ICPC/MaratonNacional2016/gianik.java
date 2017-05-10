import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Accepted in UVa
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=5032
public class gianik {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String s;
		while((s = br.readLine()) != null){
			int n = Integer.parseInt(s);

			int[] a = new int[n];
			int[] b = new int[n];

			for(int i=0; i<n; i++){
				String[] l = br.readLine().split(" ");
				a[i] = Integer.parseInt(l[1]);
				b[i] = Integer.parseInt(l[2]);
			}

			boolean eclipse = false;
			int eclipseTime = -1;

			for(int t=0; t<=360 && !eclipse; t++){
				boolean[] starAngles = new boolean[360];
				for(int j=0; j<n && !eclipse; j++){
					int angle = a[j] + b[j]*t;
					while(angle < 0){
						angle += 360;
					}
					angle = angle % 360;
					if(starAngles[angle]){
						eclipse = true;
						eclipseTime = t;
					}else{
						starAngles[angle] = true;
					}
				}
			}

			if(eclipse){
				bw.write(eclipseTime + "\n");
			}else{
				bw.write("GIANIK IS NEVER ECLIPSED\n");
			}
		}

		bw.flush();
	}
}
