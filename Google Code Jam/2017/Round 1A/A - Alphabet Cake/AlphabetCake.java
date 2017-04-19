import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted in competition for the Small and Large datasets
public class AlphabetCake {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++){
			String l[] = br.readLine().split(" ");
			int r = Integer.parseInt(l[0]);
			int c = Integer.parseInt(l[1]);
			
			char input[][] = new char[r][c];
			char output[][] = new char[r][c];
			
			for(int j=0; j<r; j++){
				char row[] = br.readLine().toCharArray();
				input[j] = row;
			}
							
			for(int j=0; j<r; j++){
				char current = '?';
				for(int k=0; k<c; k++){
					if(input[j][k] != '?'){
						current = input[j][k];
					}
					output[j][k] = current;
				}
			}
			
			for(int j=0; j<r; j++){
				char current = '?';
				for(int k=c-1; k>=0; k--){
					if(output[j][k] != '?'){
						current = output[j][k];
					}else{
						output[j][k] = current;
					}					
				}
			}
			
			int topDown = -1;
			for(int j=0; j<r; j++){
				if(output[j][0] != '?'){
					topDown = j;
				}else if(topDown != -1){
					output[j] = output[topDown];
				}
			}
			
			int bottomUp = -1;
			for(int j=r-1; j>=0; j--){
				if(output[j][0] != '?'){
					bottomUp = j;
				}else if(bottomUp != -1){
					output[j] = output[bottomUp];
				}
			}
			
			System.out.println("Case #" + i + ": ");
			for(int j=0; j<r; j++){				
				for(int k=0; k<c; k++){
					System.out.print(output[j][k]);
				}
				System.out.println();
			}
			
		}
	}	
}
