import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static boolean[] seen;
    static ArrayList<Integer> primes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        sieve(1000);

        String s;
        while((s = br.readLine()) != null) {
            String[] line = s.split(" ");
            int n = Integer.parseInt(line[0]);
            int c = Integer.parseInt(line[1]);

            int posN = Collections.binarySearch(primes, n);
            int primesUpToN;
            if(posN < 0) {
                primesUpToN = -1 * (posN+1);
            } else {
                primesUpToN = posN + 1;
            }

            int cutLength = primesUpToN % 2 == 0 ? 2*c : 2*c - 1;
            int start = (primesUpToN - cutLength) / 2;
            int end = start + cutLength - 1;

            start = start < 0 ? 0 : start;
            end = end >= primesUpToN ? primesUpToN - 1 : end;

            bw.write(n + " " + c + ": ");
            while(start <= end) {
                bw.write(primes.get(start)+"");
                if(start < end) bw.write(" ");
                start++;
            }
            bw.newLine();
            bw.newLine();
        }

        bw.flush();
    }

    public static void sieve(int n) {
        seen = new boolean[n+1];
        primes = new ArrayList<Integer>();
        // 1 is prime in this problem! Ok ._.
        primes.add(1);

        for(int i=2; i<=n; i++) {
            if(!seen[i]) {
                primes.add(i);
                for(int j=i*i; j<=n; j=j+i) {
                    seen[j] = true;
                }
            }
        }
    }

}
