import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

//Accepted in competition
//Available at: https://www.urionlinejudge.com.br/judge/en/problems/view/2697
public class C {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] l = br.readLine().split(" ");

		int k = Integer.parseInt(l[0]);
		int n = Integer.parseInt(l[1]);

		int[] frequency = new int[k];

		l = br.readLine().split(" ");

		for(int i=0; i<n; i++) {
			int x = Integer.parseInt(l[i]) - 1;
			frequency[x]++;
		}

		int min = Integer.MAX_VALUE;
		int max = -1;
		int posMin = -1;
		int posMax = -1;
		for(int j=0; j<k; j++){
			if(frequency[j] > max){
				max = frequency[j];
				posMax = j;
			}
			if(frequency[j] < min){
				min = frequency[j];
				posMin = j;
			}
		}

		boolean possible = false;

		frequency[posMax]--;
		frequency[posMin]++;
		if(isComplete(frequency)){
			possible = true;
			bw.write("-" + (posMax+1) + " ");
			bw.write("+" + (posMin+1) + "\n");
		}

		if(!possible){
			frequency[posMin]--;
			if(isComplete(frequency)){
				possible = true;
				bw.write("-" + (posMax+1) + "\n");
			}
		}

		if(!possible){
			frequency[posMin]++;
			frequency[posMax]++;
			if(isComplete(frequency)){
				possible = true;
				bw.write("+" + (posMin+1) + "\n");
			}
		}

		if(!possible) {
			bw.write("*\n");
		}

		bw.flush();
	}

	public static boolean isComplete(int[] frequency){
		int all = frequency[0];
		if(all == 0){
			return false;
		}else{
			for(int j=1; j<frequency.length; j++){
				if(frequency[j] != all){
					return false;
				}
			}
			return true;
		}
	}
}
