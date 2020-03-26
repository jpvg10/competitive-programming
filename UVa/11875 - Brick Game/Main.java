import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=1; i<=t; i++) {
            String[] line = br.readLine().split(" ");
            int n = Integer.parseInt(line[0]);
            System.out.format("Case %d: %s\n", i, line[(n/2) + 1]);
        }
    }

}
