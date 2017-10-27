import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class B {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] l = br.readLine().split(" ");
		int n = Integer.parseInt(l[0]);
		int m = Integer.parseInt(l[1]);

		if(n%3 != 0 && m%3 != 0){
			for(int i=0; i<n; i++){
				br.readLine();
			}
			System.out.println("NO");
		}else{
			char[][] flag = new char[n][m];
			for(int i=0; i<n; i++){
				flag[i] = br.readLine().toCharArray();
			}
			boolean ok = false;
			if(n%3 == 0){
				ok = checkHorizontal(flag, n, m);
			}
			if(!ok && m%3 == 0){
				ok = ok || checkVertical(flag, n, m);
			}
			if(ok){
				System.out.println("YES");
			}else{
				System.out.println("NO");
			}
		}
	}

	public static boolean checkHorizontal(char[][] flag, int n, int m){
		char previous = flag[0][0];
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		count.put('R', 0);
		count.put('G', 0);
		count.put('B', 0);
		for(int i=0; i<n; i++){
			char current = flag[i][0];
			if(current != previous && count.get(current) != 0){
				return false;
			}else{
				previous = current;
			}
			count.put(current, count.get(current) + 1);
			for(int j=1; j<m; j++){
				if(flag[i][j] != current){
					return false;
				}
			}
		}
		if(count.get('R') == count.get('B') && count.get('B') == count.get('G')){
			return true;
		}else{
			return false;
		}
	}

	public static boolean checkVertical(char[][] flag, int n, int m){
		char previous = flag[0][0];
		HashMap<Character, Integer> count = new HashMap<Character, Integer>();
		count.put('R', 0);
		count.put('G', 0);
		count.put('B', 0);
		for(int j=0; j<m; j++){
			char current = flag[0][j];
			if(current != previous && count.get(current) != 0){
				return false;
			}else{
				previous = current;
			}
			count.put(current, count.get(current) + 1);
			for(int i=1; i<n; i++){
				if(flag[i][j] != current){
					return false;
				}
			}
		}
		if(count.get('R') == count.get('B') && count.get('B') == count.get('G')){
			return true;
		}else{
			return false;
		}
	}

}
