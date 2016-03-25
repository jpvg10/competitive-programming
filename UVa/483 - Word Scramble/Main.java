import java.util.Scanner;

public class Main {
    
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(sc.hasNextLine()){
			String l[] = sc.nextLine().split(" ");
			StringBuilder sb = new StringBuilder();
			for(int i=0; i<l.length; i++){
				if(!l[i].equals("")){
					StringBuilder a = new StringBuilder(l[i]).reverse();
					sb.append(a);
					if(i != l.length-1){
						sb.append(" ");
					}			
				}				
			}
			System.out.println(sb.toString());
		}
	}
}
