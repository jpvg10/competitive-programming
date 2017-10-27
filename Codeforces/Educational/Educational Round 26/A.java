import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		String[] text = br.readLine().split(" ");

		int maxVolume = 0;

		for(int i=0; i<text.length; i++){
			String word = text[i];
			int volume = 0;
			for(int j=0; j<word.length(); j++){
				if(Character.isUpperCase(word.charAt(j))){
					volume++;
				}
			}
			if(volume > maxVolume){
				maxVolume = volume;
			}
		}

		System.out.println(maxVolume);
	}

}
