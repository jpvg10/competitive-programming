import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted in competition
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=866&page=show_problem&problem=4900
public class I {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String ts;
		while( (ts = br.readLine()) != null ){
			String p[] = br.readLine().split(" ");
			int count = 0;
			for(int i = 0; i < 5; i++){
				if(p[i].equals(ts)) count++;
			}
			System.out.println(count);
		}
	}
}