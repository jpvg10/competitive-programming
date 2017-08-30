import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int[] snowflakes = new int[n];
			for(int j=0; j<n; j++) {
				snowflakes[j] = Integer.parseInt(br.readLine());
			}

			LinkedList<Integer> unique = new LinkedList<Integer>();
			HashMap<Integer, Integer> index = new HashMap<Integer, Integer>();

			int max = 0;

			for(int j=0; j<n; j++) {
				int s = snowflakes[j];
				if(index.containsKey(s)) {
					int k = unique.peek();
					int len = j - k;
					max = Integer.max(len, max);
					int prevIndex = index.get(s);
					while(!unique.isEmpty() && unique.peek() <= prevIndex) {
						k = unique.poll();
						index.remove(snowflakes[k]);
					}
					unique.add(j);
					index.put(s, j);
				}else {
					unique.add(j);
					index.put(s, j);
				}
			}

			if(!unique.isEmpty()) {
				max = Integer.max(unique.size(), max);
			}

			System.out.println(max);
		}

	}

}
