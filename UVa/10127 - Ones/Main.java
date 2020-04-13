import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);

            int digits = 1;
            int current = 1;

            while(current % n != 0) {
                current = ((current * 10) % n + 1) % n;
                digits++;
            }

            System.out.println(digits);
        }
    }

}
