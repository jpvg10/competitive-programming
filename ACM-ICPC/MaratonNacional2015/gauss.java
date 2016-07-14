import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

//Accepted in competition
//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4825
public class gauss {

	public static void main(String[] args) throws IOException {
		BufferedReader scan = new BufferedReader(new InputStreamReader(System.in));
		
		String line;		
		while((line = scan.readLine()) != null){
			long num = Long.parseLong(line);
			long n = num;
			int unos[] = new int[100];
			Arrays.fill(unos, -1);
			int count = 0;
			int contadorUnos = 0;
			while(n>0){
				if(n % 2 == 1){
					unos[contadorUnos] = count;
					contadorUnos++;						
				}
				count++;
				n = n/2;
			}
			
			int r[] = new int[2];
			r[0] = 0;
			r[1] = 0;
			for(int i = 0; unos[i] != -1 && i < count; i++){
				int power[] = complexPow(unos[i]);
				r[0] += power[0];
				r[1] += power[1];
			}
			System.out.println(r[1]+" "+r[0]);
		}		
	}
	
	//Finds the result of (i-1)^k = a[0]*i+a[1]
	public static int[] complexPow(int k){
		int a[] = new int[2];
		if(k==0){
			a[0] = 0;
			a[1] = 1;
		}else if(k==1){
			a[0] = 1;
			a[1] = -1;
		}else{
			boolean negPar = true;
			boolean complexPar = true;
			boolean negImparReal = false;
			boolean negImparComplejo = false;
			
			if(k%2 == 0){
				for(int i=2; i<=k; i=i+2){
					if(negPar && complexPar){
						a[0] = (-1)*(int)Math.pow(2, i/2);
						a[1] = 0;
						complexPar = false;
					}else if(negPar && !complexPar){
						a[0] = 0;
						a[1] = (-1)*(int)Math.pow(2, i/2);
						negPar = false;
						complexPar = true;
					}else if(!negPar && complexPar){
						a[0] = (int)Math.pow(2, i/2);
						a[1] = 0;
						complexPar = false;
					}else{
						a[0] = 0;
						a[1] = (int)Math.pow(2, i/2);
						negPar = true;
						complexPar = true;
					}
				}
			}else{
				for(int i=3; i<=k; i=i+2){
					int r = (int)Math.pow(2, i/2);
					if(!negImparComplejo && !negImparReal){
						a[0] = r;
						a[1] = r;
						negImparComplejo = true;
					}else if(negImparComplejo && !negImparReal){
						a[0] = -r;
						a[1] = r;
						negImparReal = true;
					}else if(negImparComplejo && negImparReal){
						a[0] = -r;
						a[1] = -r;
						negImparComplejo = false;
					}else{
						a[0] = r;
						a[1] = -r;
						negImparReal = false;
					}
				}
			}
		}
		return a;
	}
}
