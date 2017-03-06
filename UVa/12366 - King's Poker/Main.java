import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l = br.readLine()) != null){
			String s[] = l.split(" ");

			int cards[] = new int[3];
			for(int i=0; i<3; i++){
				cards[i] = Integer.parseInt(s[i]);
			}
			if(cards[0] == 0) break;

			Arrays.sort(cards);

			ArrayList<Integer> ans = new ArrayList<Integer>();

			if(cards[0] == cards[1] && cards[1] == cards[2]){
				if(cards[0] != 13){
					int a = cards[0] + 1;
					ans.add(a);
					ans.add(a);
					ans.add(a);
				}
			}else if(cards[0] == cards[1] || cards[1] == cards[2]){
				int same, odd;
				if(cards[0] == cards[1]){
					same = cards[0];
					odd = cards[2];
				}else{
					same = cards[1];
					odd = cards[0];
				}

				if(same == 13 && odd == 12){
					ans.add(1);
					ans.add(1);
					ans.add(1);
				}else if(odd == 13){
					same++;
					ans.add(1);
					ans.add(same);
					ans.add(same);
				}else{
					odd++;
					if(same == odd) odd++;
					ans.add(odd);
					ans.add(same);
					ans.add(same);
				}
			}else{
				ans.add(1);
				ans.add(1);
				ans.add(2);
			}

			if(ans.size() == 0){
				System.out.println("*");
			}else{
				Collections.sort(ans);
				System.out.println(ans.get(0) + " " + ans.get(1) + " " + ans.get(2));
			}
		}
	}
}
