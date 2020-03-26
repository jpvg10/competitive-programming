import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            String t = br.readLine();
            BigInteger x = new BigInteger(s);
            BigInteger y = new BigInteger(t);
            System.out.println(x.multiply(y));
        }
    }

}
