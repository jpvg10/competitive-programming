import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class Main {
	
	static ArrayList<String> words;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String eot = "****END_OF_TEXT****"; 
		String eoi = "****END_OF_INPUT****";	
		
		words = new ArrayList<String>();
		
		String s;
		while(!(s = br.readLine()).equals(eoi)){
			if(s.equals(eot)){
				HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
				
				int l = words.size();
								
				for(String w : words){					
					if(wordMap.containsKey(w)){
						int f = wordMap.get(w);
						wordMap.put(w, f+1);
					}else{
						wordMap.put(w, 1);
					}									
				}				
								
				double et = 0;
				for(Entry<String, Integer> w: wordMap.entrySet()){
					int pi = w.getValue();
					et += pi*(Math.log10(l)-Math.log10(pi));
				}
				
				et = et/l;
				double erel = et/Math.log10(l)*100;
				
				System.out.println(String.format("%d %.1f %.0f", l, et, erel));
				
				words = new ArrayList<String>();
			}else{
				if(!s.equals("")) 
					process(s);	
			}
		}
	}
				
	public static void process(String s){		
		int a = 0;		
		int b = 0;
		int l = s.length();
		while(b<=l){
			if(isWhite(s.charAt(a))){
				while(a < l && isWhite(s.charAt(a))){
					a++;					
				}
				if(a == l) break;
				b = a;
			}else{
				if(b == l ||  isWhite(s.charAt(b))){
					words.add(s.substring(a, b).toLowerCase());
					a = b;					
				}
				b++;
			}			
		}		
	}
	
	public static boolean isWhite(char c){
		if(Character.isWhitespace(c) || c==',' || c=='.' || c==':' || c==';' || c=='!' || c=='?'|| c=='"' || c=='(' || c==')')
			return true;
		else
			return false;		
	}
}
