import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

//Accepted for both Small datasets in Practice Mode
public class BathroomStalls {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int i=1; i<=t; i++){
			String line[] = br.readLine().split(" ");
			int n = Integer.parseInt(line[0]);
			int k = Integer.parseInt(line[1]);

			PriorityQueue<Integer> sets = new PriorityQueue<Integer>(Collections.reverseOrder());
			sets.add(n);

			int max = -1;
			int min = -1;
			for(int j=0; j<k; j++){
				int chosen = sets.poll();
				max = chosen/2;
				if(chosen % 2 == 0){
					min = max-1;
				}else{
					min = max;
				}
				sets.add(min);
				sets.add(max);
			}

			System.out.println("Case #" + i + ": " + max + " " + min);
		}
	}
}
