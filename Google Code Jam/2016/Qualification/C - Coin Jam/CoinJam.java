import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

//Accepted in competition for the Small dataset
public class CoinJam {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
						
		for(int i=1; i<=t; i++){
			String in[] = br.readLine().split(" ");
			int n = Integer.parseInt(in[0]);
			int j = Integer.parseInt(in[1]);
			
			int count = 0;
			//int max = (int)Math.pow(2, n-2) - 1;
			int k = 0;
			
			System.out.println("Case #" + i + ": ");
			
			while(count < j){
				String bits = Integer.toBinaryString(k);
				int zeros = n - bits.length() - 2;
				for(int z=0; z<zeros; z++){
					bits = "0" + bits;
				}
				bits = "1" + bits + "1";
				boolean isOk = true;
				String divisors[] = new String[9];
				for(int b=2; b<=10; b++){
					BigInteger candidate = getInBase(bits, b);
					if(candidate.isProbablePrime(10)){
						isOk = false;
						break;
					}else{
						divisors[b-2] = getADivisor(candidate).toString();
					}					
				}	
				if(isOk){
					System.out.print(bits);
					for(int d=0; d<9; d++){
						System.out.print(" " + divisors[d]);
					}
					System.out.println();
					count++;
				}
				k++;
			}
		}
	}
	
	public static BigInteger getInBase(String s, int b){
		int len = s.length();
		long pow = 1;
		long res = 0;
		for(int i=1; i<=len; i++){
			if(s.charAt(len-i) == '1'){
				res = res + pow;
			}
			pow = pow*b;
		}
		return new BigInteger(Long.toString(res));
	}
	
	public static BigInteger getADivisor(BigInteger c){
		BigInteger d = new BigInteger("2");
		BigInteger zero = new BigInteger("0");
		BigInteger one = new BigInteger("1");
		while(true){
			if(c.mod(d).equals(zero)){
				return d;
			}
			d = d.add(one);
		}
	}
}
