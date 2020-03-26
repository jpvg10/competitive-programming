import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            long n = Long.parseLong(s);
            long lineIndex = (n-1) / 2;
            long mLast = (lineIndex+1)*(lineIndex+1) - 1;
            long lastOfRow = 2*mLast + 1;
            long sum = 3*lastOfRow - 6;
            System.out.println(sum);
        }
    }

}
