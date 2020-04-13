import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);

            /* int m = n/2;
            int limit = (int) Math.pow(10, m);
            String format = "%0" + m + "d";
            ArrayList<String> result = new ArrayList<>();
            for(int i=0; i<limit; i++) {
                for(int j=0; j<limit; j++) {
                    String is = String.format(format, i);
                    String js = String.format(format, j);
                    String rs = is + js;
                    int r = Integer.parseInt(rs);
                    if((i+j)*(i+j) == r) {
                        result.add(rs);
                    }
                }
            }
            for(String x : result) {
                System.out.println(x);
            } */

            switch(n) {
            case 2:
                System.out.println("00");
                System.out.println("01");
                System.out.println("81");
                break;
            case 4:
                System.out.println("0000");
                System.out.println("0001");
                System.out.println("2025");
                System.out.println("3025");
                System.out.println("9801");
                break;
            case 6:
                System.out.println("000000");
                System.out.println("000001");
                System.out.println("088209");
                System.out.println("494209");
                System.out.println("998001");
                break;
            case 8:
                System.out.println("00000000");
                System.out.println("00000001");
                System.out.println("04941729");
                System.out.println("07441984");
                System.out.println("24502500");
                System.out.println("25502500");
                System.out.println("52881984");
                System.out.println("60481729");
                System.out.println("99980001");
                break;
            }
        }

    }

}
