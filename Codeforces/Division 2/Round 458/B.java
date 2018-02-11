import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map.Entry;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());

		String[] a = br.readLine().split(" ");

		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();

		for(int i=0; i<n; i++){
			int x = Integer.parseInt(a[i]);
			if(count.containsKey(x)){
				count.put(x, count.get(x) + 1);
			}else{
				count.put(x, 1);
			}
		}

		boolean someOdd = false;

		for(Entry<Integer, Integer> e : count.entrySet()){
			if(e.getValue() % 2 != 0){
				someOdd = true;
				break;
			}
		}

		if(someOdd){
			System.out.println("Conan");
		}else{
			System.out.println("Agasa");
		}
	}

}
