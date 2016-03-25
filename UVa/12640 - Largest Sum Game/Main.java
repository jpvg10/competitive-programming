import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l;		
        while((l = br.readLine()) != null){
            String s[] = l.split(" ");
            int n = s.length;
            int x[] = new int[n];
            for(int i=0; i<n; i++)
                x[i] = Integer.parseInt(s[i]);

            int b[] = new int[n];

            if(x[0]<0)
                b[0] = 0;
            else
                b[0] = x[0];

            for(int i=1; i<n; i++){
                if(b[i-1]+x[i]>0)
                    b[i] = b[i-1]+x[i];
                else
                    b[i] = 0;					
            }

            int max = 0;
            for(int i=0; i<n; i++)
                if(b[i]>max)
                    max = b[i];

            System.out.println(max);
        }		
	}
}
