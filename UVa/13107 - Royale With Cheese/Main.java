
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

//Problema de la competencia 05 de la RPC 2016
public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        
        String a;
        while((a=sc.readLine()) != null){
            HashMap<Character, Integer> map = new HashMap<Character, Integer>();
            StringBuilder ans = new StringBuilder();
            int cont = 1;
            for (int i=0; i<a.length(); i++) {
                char c = a.charAt(i);
                if(map.containsKey(c)){
                    ans.append(map.get(c));
                }else{
                    map.put(c, cont);
                    cont++;
                    ans.append(map.get(c));
                }                
            }
            
            for (int i = 0; i < ans.length(); i++) {
                if(ans.charAt(i)=='2'){
                    ans.setCharAt(i, '5');
                }else if(ans.charAt(i)=='5'){
                    ans.setCharAt(i, '2');
                }else if(ans.charAt(i)=='6'){
                    ans.setCharAt(i, '9');
                }else if(ans.charAt(i)=='9'){
                    ans.setCharAt(i, '6');
                }                
            }
            
            System.out.println(ans.toString());           
        }
    }    
}
