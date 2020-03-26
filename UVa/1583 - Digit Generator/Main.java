import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            String s = br.readLine();
            int n = Integer.parseInt(s);
            int start = n - (9*s.length());
            int generator = 0;
            while(start < n && generator == 0) {
                if(start + digitSum(start) == n) {
                    generator = start;
                }
                start++;
            }
            System.out.println(generator);
        }
    }

    public static int digitSum(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int sum = 0;
        for(char c : chars) {
            sum += c - '0';
        }
        return sum;
    }

}
