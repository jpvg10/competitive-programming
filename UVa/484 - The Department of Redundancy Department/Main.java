import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		
		String l;
		while((l = br.readLine()) != null){
			String numbers[] = l.split(" ");
						
			for(int i=0; i<numbers.length; i++){
				if(!map.containsKey(numbers[i])){
					map.put(numbers[i], 1);
				}else{
					int k = map.get(numbers[i]);
					map.put(numbers[i], k+1);
				}
			}
		}
		
		for(Entry<String, Integer> e : map.entrySet()){
			System.out.println(e.getKey() + " " + e.getValue());
		}
	}
}
