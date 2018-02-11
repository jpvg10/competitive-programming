import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Available at: https://uva.onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=4650
public class emacs {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String l;
		while((l=br.readLine()) != null){
			int n = Integer.parseInt(l);
			String text = br.readLine();
			for(int i=0; i<n; i++){
				String patterns[] = br.readLine().split("\\*");
				int start = 0;
				for(int k=0; k<patterns.length && start != -1; k++){
					if(!patterns[k].equals(""))
						start = KMP(text, patterns[k], start);
				}
				if(start != -1)
					System.out.println("yes");
				else
					System.out.println("no");
			}
		}
	}

	private static int[] computeTemporaryArray(String pattern){
		int [] lps = new int[pattern.length()];
		int index = 0;
		int i = 1;
		while(i < pattern.length()){
			if(pattern.charAt(i) == pattern.charAt(index)){
				lps[i] = index + 1;
				index++;
				i++;
			}else{
				if(index != 0){
					index = lps[index-1];
				}else{
					lps[i] = 0;
					i++;
				}
			}
		}
		return lps;
	}

	public static int KMP(String text, String pattern, int start){
		int lps[] = computeTemporaryArray(pattern);
		int i=start;
		int j=0;
		while(i < text.length() && j < pattern.length()){
			if(text.charAt(i) == pattern.charAt(j)){
				i++;
				j++;
			}else{
				if(j!=0){
					j = lps[j-1];
				}else{
					i++;
				}
			}
		}
		if(j == pattern.length())
			return i;
		else
			return -1;
	}
}
