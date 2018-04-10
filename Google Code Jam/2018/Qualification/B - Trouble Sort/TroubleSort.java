import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

//Accepted in competition for the Small and Large datasets
public class TroubleSort {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int i=1; i<=t; i++){
			int n = Integer.parseInt(br.readLine());
			String[] l = br.readLine().split(" ");

			ArrayList<Integer> even = new ArrayList<Integer>();
			ArrayList<Integer> odd = new ArrayList<Integer>();

			for(int j=0; j<n; j++){
				if(j%2 == 0){
					even.add(Integer.parseInt(l[j]));
				}else{
					odd.add(Integer.parseInt(l[j]));
				}
			}

			Collections.sort(even);
			Collections.sort(odd);

			System.out.print("Case #" + i + ": ");

			boolean ok = true;
			int prev = even.get(0);

			for(int j=1; j<n; j++){
				int current;
				if(j%2 == 0){
					current = even.get(j/2);
				}else{
					current = odd.get(j/2);
				}
				if(current < prev){
					System.out.println(j-1);
					ok = false;
					break;
				}
				prev = current;
			}

			if(ok) System.out.println("OK");
		}
	}

}
