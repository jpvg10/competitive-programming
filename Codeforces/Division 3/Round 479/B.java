import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class B {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = Integer.parseInt(sc.nextLine());
		String s = sc.nextLine();

		HashMap<String, Integer> twoGram = new HashMap<>();

		for(int i=0; i<n-1; i++){
			String sub = s.substring(i, i+2);
			if(twoGram.containsKey(sub)){
				twoGram.put(sub, twoGram.get(sub) + 1);
			}else{
				twoGram.put(sub, 1);
			}
		}

		int max = 0;
		String ans = "";
		for(Entry<String, Integer> e : twoGram.entrySet()){
			if(e.getValue() > max){
				max = e.getValue();
				ans = e.getKey();
			}
		}

		System.out.println(ans);

		sc.close();

	}

}
