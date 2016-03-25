import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int mod = 1000000007;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
        int cases = Integer.parseInt(reader.readLine());			

        for(int t=1; t<=cases; t++){				
            String bits = reader.readLine();
            int size = bits.length();
            int half_size = size/2;
            int pleft = 0, pright = 0;

            if(size%2==0){
                pleft = half_size - 1;
                pright = half_size;
            }else{
                pright = half_size;
                pleft = pright;
            }

            int middle = 0, skip = 0;
            boolean lskip = true;

            long actual = 0;

            for(int b=0; b<size; b++){
                skip++;
                if(pleft == pright){
                    //Current size odd
                    middle = pleft;
                    if(lskip){
                        pleft -= skip;
                        pright++;
                    }else{
                        pleft--;
                        pright += skip;
                    }
                }else{
                    //Current size even
                    middle = bits.charAt(pleft)>bits.charAt(pright)? pleft : pright;
                    if(middle == pleft){
                        pleft += skip;
                        lskip = true;
                    }else{
                        pright -= skip;
                        lskip = false;
                    }
                }					

                long binary_value = (bits.charAt(middle)-'0');

                if(binary_value==0){
                    actual = (actual*2)%mod;
                }else{
                    actual = (actual*2+1)%mod;
                }									
            }	
            System.out.println("Case #" + t + ": " + actual);
        }	
	}
}
