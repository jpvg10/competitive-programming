
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Problema de la competencia 05 de la RPC 2016
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());

		for(int i=0; i<t; i++){
			String l[] = br.readLine().split(" ");
			int m = Integer.parseInt(l[0]);
			int w = Integer.parseInt(l[1]);
			l = br.readLine().split(" ");
			int weights[] = new int[m];

			for(int j=0; j<m; j++){
				weights[j] = Integer.parseInt(l[j]);
			}

			Arrays.sort(weights);

			int sum = 0;
			int e = 0;
			for(int k=0; k<m; k++){
				if(sum + weights[k] <= w){
					sum += weights[k];
					e++;
				}else{
					break;
				}
			}

			System.out.println(e);
		}
	}
}
