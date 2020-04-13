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

        int n = Integer.parseInt(br.readLine());

        HashMap<Character, Integer> map = new HashMap<>();

        for(int l=0; l<n; l++) {
            char[] array = br.readLine().toUpperCase().toCharArray();
            for(char c : array) {
                if(Character.isAlphabetic(c)) {
                    if(map.containsKey(c)) {
                        map.put(c, map.get(c) + 1);
                    } else {
                        map.put(c, 1);
                    }
                }
            }
        }

        ArrayList<Pair> result = new ArrayList<>();

        for(Entry<Character, Integer> e : map.entrySet()) {
            result.add(new Pair(e.getKey(), e.getValue()));
        }

        Collections.sort(result);

        for(Pair p : result) {
            System.out.format("%c %d\n", p.letter, p.freq);
        }
    }

}

class Pair implements Comparable<Pair> {
    char letter;
    int freq;
    public Pair(char letter, int freq) {
        this.letter = letter;
        this.freq = freq;
    }
    public int compareTo(Pair o) {
        if (this.freq != o.freq) {
            return o.freq - this.freq;
        } else {
            return Character.compare(this.letter, o.letter);
        }
    }
}
