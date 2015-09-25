import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Accepted
public class emacs {

	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l;
		try {
			while((l=br.readLine()) != null){
				int n = Integer.parseInt(l);
				String text = br.readLine();
				for(int i=0; i<n; i++){
					String patterns[] = br.readLine().split("\\*");					
					int inicio = 0;
					for(int k=0; k<patterns.length && inicio != -1; k++){
						if(!patterns[k].equals(""))
							inicio = KMP(text, patterns[k], inicio);									
					}
					if(inicio != -1)
						System.out.println("yes");
					else
						System.out.println("no");					
				}
			}
		} catch (IOException e) {			
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
        if(j == pattern.length()){
        	return i;        	        
        }
        return -1;
    }

}
