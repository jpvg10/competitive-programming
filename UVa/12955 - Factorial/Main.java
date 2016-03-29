import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Problema de la competencia 09 de la RPC 2015
public class Main {

	public static void main(String[] args) throws IOException {
		int factorials[] = {1, 2, 6, 24, 120, 720, 5040, 40320};
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l;		
        while((l = br.readLine()) != null){
            int n = Integer.parseInt(l);

            int r = 0;

            int i = 7;
            while(n>0){
                while(factorials[i]>n){
                    i--;
                }
                n = n-factorials[i];
                r++;
            }	

            System.out.println(r);
        }		
	}
}
