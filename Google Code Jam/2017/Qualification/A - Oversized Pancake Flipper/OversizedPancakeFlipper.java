import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted for the small and large datasets in Practice Mode
public class OversizedPancakeFlipper {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++){
			String line[] = br.readLine().split(" ");
			
			String s = line[0];
			int n = s.length();
			int k = Integer.parseInt(line[1]);
			boolean pancakes[] = new boolean[n];
			
			for(int j=0; j<n; j++){
				if(s.charAt(j) == '+'){
					pancakes[j] = true;
				}
			}
			
			int flips = 0;
			
			for(int j=0; j<=n-k; j++){
				if(!pancakes[j]){
					flips++;
					for(int f=0; f<k; f++){
						pancakes[j+f] = !pancakes[j+f];
					}					
				}
			}
			
			boolean possible = true;
			
			for(int j=n-k; j<n; j++){
				if(!pancakes[j]){
					possible = false;
					break;
				}
			}
			
			if(possible){
				System.out.println("Case #" + i + ": " + flips);
			}else{
				System.out.println("Case #" + i + ": IMPOSSIBLE");
			}
		}		
	}
	
}
