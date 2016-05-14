import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

//Accepted for Small and Large in Practice
public class RankAndFile {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++){
			int n = Integer.parseInt(br.readLine());
			
			HashMap<Integer, Integer> soldiers = new HashMap<Integer, Integer>();
			
			for(int j=0; j<2*n-1; j++){
				String line[] = br.readLine().split(" ");
				for(int k=0; k<n; k++){
					int h = Integer.parseInt(line[k]);
					if(!soldiers.containsKey(h)){
						soldiers.put(h, 1);
					}else{
						int current = soldiers.get(h);
						soldiers.put(h, current+1);
					}
				}
				
			}
			
			ArrayList<Integer> missing = new ArrayList<Integer>();
			
			for(Entry<Integer, Integer> e : soldiers.entrySet()){
				if(e.getValue() % 2 != 0){
					missing.add(e.getKey());
				}
			}
			
			Collections.sort(missing);
			
			System.out.print("Case #" + i + ": ");
			for(int j : missing) System.out.print(j + " ");
			System.out.println();
		}
	}
}
