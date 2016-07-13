import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//Problema de la competencia 05 de la RPC 2016
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++){
			int n = Integer.parseInt(br.readLine());
			int sn = (int) Math.sqrt(n);

			String sudo[][] = new String[n][n];

			HashSet<String> row[] = new HashSet[n];
			HashSet<String> column[] = new HashSet[n];
			HashSet<String> square[][] = new HashSet[sn][sn];

			for(int j=0; j<n; j++){
				sudo[j] = br.readLine().split(" ");
				row[j] = new HashSet<String>();
				column[j] = new HashSet<String>();
			}

			for(int j=0; j<sn; j++){
				for(int k=0; k<sn; k++){
					square[j][k] = new HashSet<String>();
				}
			}

			boolean ok = true;

			for(int j=0; j<n && ok; j++){
				for(int k=0; k<n && ok; k++){
					String num = sudo[j][k];
					if(row[j].contains(num)){
						ok = false;
					}else{
						row[j].add(num);
					}
					if(column[k].contains(num)){
						ok = false;
					}else{
						column[k].add(num);
					}
					int sj = j / sn;
					int sk = k / sn;
					if(square[sj][sk].contains(num)){
						ok = false;
					}else{
						square[sj][sk].add(num);
					}
				}
			}

			if(ok) System.out.println("yes");
			else System.out.println("no");
		}
	}
}
