import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4651
public class fnets {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String line;
		while((line = br.readLine()) != null){
			String s[] = line.split(" ");
			int n = Integer.parseInt(s[0]);
			int v[] = new int[n];
			int degree[] = new int[n];
			
			boolean possible = true;
			
			for(int i=1; i<=n; i++){
				v[i-1] = Integer.parseInt(s[i]);
				if(v[i-1] > n) {
					possible = false;
					break;
				}
			}
			
			if(possible) {
				degree = sortReverse(v);
			}
			
			while(degree[0] != 0 && possible){
				int friends = degree[0];
				for(int j=1; j<=friends; j++){
					if(degree[j] == 0) {
						possible = false;
						break;
					}
					degree[j]--;
				}
				degree[0] = 0;
				degree = bubble(degree);
			}
										
			System.out.println(possible ? 1 : 0);
		}
	}
	
	public static int[] sortReverse(int v[]){
		Arrays.sort(v);
		int r[] = new int[v.length];
		for(int i=0; i<v.length; i++){
			r[i] = v[v.length-i-1];
		}
		return r;
	}
	
	public static int[] bubble(int v[]){		
		boolean change = true;
		for(int i=0; i<v.length && change; i++){
			change = false;
			for(int j=0; j<v.length-i-1; j++){
				if(v[j] < v[j+1]){
					int t = v[j];
					v[j] = v[j+1];
					v[j+1] = t;
					change = true;
				}
			}
		}
		return v;
	}
}
