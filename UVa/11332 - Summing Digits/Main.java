import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            if(n != 0) {
                System.out.println(g(n));
            }
        }
    }

    public static int g(int n) {
        char[] s = String.valueOf(n).toCharArray();
        int sum = 0;
        for(char c : s) {
            sum += c - '0';
        }
        if(sum / 10 == 0) {
            return sum;
        } else {
            return g(sum);
        }
    }

}
