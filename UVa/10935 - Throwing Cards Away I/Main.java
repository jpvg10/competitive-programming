import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while((s = br.readLine()) != null) {
            int n = Integer.parseInt(s);
            if(n == 0) break;

            LinkedList<Integer> l = new LinkedList<>();
            for(int i=1; i<=n; i++) {
                l.add(i);
            }

            System.out.print("Discarded cards:");

            while(l.size() >= 2) {
                int x = l.removeFirst();
                System.out.format(" %d", x);
                if(l.size() > 1) System.out.print(",");
                x = l.removeFirst();
                l.addLast(x);
            }

            System.out.print("\n");
            System.out.format("Remaining card: %d\n", l.removeFirst());
        }
    }
}
