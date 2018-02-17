import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class C {

	private static Map<Integer,ArrayList<Character>> map;
	private static int remove;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s[] = sc.nextLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);

		map = new TreeMap<Integer, ArrayList<Character>>();

		for(int i=0; i<n; i++){
			String l = sc.nextLine();
			ArrayList<Character> z = new ArrayList<Character>();
			for(int j=0; j<m; j++){
				z.add(l.charAt(j));
			}
			map.put(i, z);
		}

		solve();

		System.out.println(remove);
	}

	public static int isLess(int a, int b){
		ArrayList<Character> x = map.get(a);
		ArrayList<Character> y = map.get(b);

		return check(x, y, 0, x.size());
	}

	public static int check(ArrayList<Character> x, ArrayList<Character> y, int i, int n){
		if(i >= n){
			return -1;
		}else if(x.get(i) > y.get(i)){
			return i;
		}else if(x.get(i) < y.get(i)){
			return -1;
		}else{
			i++;
			return check(x, y, i, n);
		}
	}

	public static void removeColumn(int c){
		remove++;
		Iterator<Integer> it = map.keySet().iterator();
		while(it.hasNext()){
			int index = it.next();
			map.get(index).remove(c);
		}
	}

	public static void solve(){
		Iterator<Integer> it = map.keySet().iterator();
		int anterior, actual = it.next();
		int change = 0;

		while(it.hasNext()){
			anterior = actual;
			actual = it.next();
			int index = isLess(anterior, actual);
			if(index != -1){
				removeColumn(index);
				change++;
			}
		}

		if(change!=0){
			solve();
		}
	}

}
