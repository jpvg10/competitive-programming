import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Problema de la competencia 03 de la RPC 2016
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String l;
		while((l = br.readLine()) != null){
			String authors[] = l.split(" ");
			String name[] = br.readLine().split(" ");
			
			if(authors.length != name.length){
				System.out.println("no");
			}else{
				boolean ok = true;
				for(int i=0; i<authors.length; i++){
					if(authors[i].charAt(0) != name[i].charAt(0)){
						ok = false;
						break;
					}
				}
				if(ok) System.out.println("yes");
				else System.out.println("no");
			}
		}
	}
}
