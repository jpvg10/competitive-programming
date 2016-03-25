import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l;		
        while((l = br.readLine()) != null){
            String numeros[] = l.split(" ");
            long n = Long.parseLong(numeros[0]);
            long b = Long.parseLong(numeros[1]);

//				
//				while(4*n-4 < b){
//					b = b-(4*n-4);
//					n = n-2;
//					iteraciones++;
//				}
//				

            double t = (n-Math.sqrt(n*n-b))/2;

            long i = (long)Math.floor(t);

            long nf = n - 2*i;
            long bf = b + 4*i*i - 4*n*i;

            long c, r;

            if(bf<=nf){
                c = i+bf;
                r = i+1;
            }else if(bf<=2*nf-1){
                c = i+nf;
                r = i+bf-nf+1;
            }else if(bf<=3*nf-2){
                c = i+3*nf-bf-1;
                r = i+nf;
            }else{
                c = i+1;
                r = i+4*nf-bf-2;
            }

            System.out.println(r+" "+c);
        }					
	}
}
