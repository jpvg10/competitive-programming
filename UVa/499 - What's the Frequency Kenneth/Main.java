import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        while((s = br.readLine()) != null) {
            HashMap<Character, Integer> freqs = new HashMap<>();
            char[] chars = s.toCharArray();
            for(char c : chars) {
                if(Character.isAlphabetic(c)) {
                    if(freqs.containsKey(c)) {
                        freqs.put(c, freqs.get(c) + 1);
                    } else {
                        freqs.put(c, 1);
                    }
                }
            }

            ArrayList<Character> mostCommon = new ArrayList<Character>();
            int max = -1;
            for(Entry<Character, Integer> e : freqs.entrySet()) {
                if(e.getValue() > max) {
                    max = e.getValue();
                    mostCommon.clear();
                    mostCommon.add(e.getKey());
                } else if(e.getValue() == max) {
                    mostCommon.add(e.getKey());
                }
            }

            Collections.sort(mostCommon);
            StringBuilder sb = new StringBuilder();
            for(char c : mostCommon) {
                sb.append(c);
            }

            System.out.format("%s %d\n", sb.toString(), max);
        }
    }

}
