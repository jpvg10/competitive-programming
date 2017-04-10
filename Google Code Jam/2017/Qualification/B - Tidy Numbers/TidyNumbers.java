import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted in competition for the Small and Large datasets
public class TidyNumbers {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++){
			String line = br.readLine();
			int l = line.length();
			int n[] = new int[l];
			for(int j=0; j<l; j++){
				n[j] = line.charAt(j) - '0';
			}
			
			int firstGreater;
			do{
				firstGreater = -1;
				for(int j=1; j<l; j++){
					if(n[j] < n[j-1]){
						firstGreater = j-1;
						break;
					}
				}
				if(firstGreater != -1){
					n[firstGreater] = n[firstGreater] - 1;
					for(int k = firstGreater + 1; k<l; k++){
						n[k] = 9;
					}
				}
			}while(firstGreater != -1);
			
			boolean leadingZero = true;
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<l; j++){
				if(n[j] != 0 || !leadingZero){
					leadingZero = false;
					sb.append(n[j]);
				}
			}
			
			System.out.println("Case #" + i + ": " + sb.toString());
		}
		
	}

}
