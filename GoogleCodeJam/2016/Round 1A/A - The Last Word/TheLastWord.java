import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

//Accepted for Small and Large in Practice
public class TheLastWord {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=t; i++){
			char s[] = br.readLine().toCharArray();
			LinkedList<Character> lastWord = new LinkedList<Character>();
			lastWord.add(s[0]);
			for(int j=1; j<s.length; j++){
				if(s[j] >= lastWord.getFirst()){
					lastWord.addFirst(s[j]);
				}else{
					lastWord.addLast(s[j]);
				}
			}
			
			System.out.print("Case #" + i + ": ");			
			for(char c : lastWord) System.out.print(c);			
			System.out.println();
		}
	}

}
